define("inno/en/table/1.0/table",function(require, exports, module){
	var $=require("$");
	var Class=require("class");
	require("./table-debug.css");
	

	var Table={
		attrs:{
			xaxis:{"children": [] },
			yaxis:{"isRoot":true,"children": [] },
			title:{"id":"","text":""},
			tableTitle:"",
			content:null,
			maxColSize:-1,
			xaxisLeafNodeIdArr:[],
			yaxisLeafNodeIdArr:[],
			hasAxis:true,
			splitTable:false,
			splitTableColSize:10,
			splitTableString:"_表",
			joinString:"AND",
			congelationTitle:true,
			successCallBack:null,
		},
		
		addAxis:function (){
			var xaxisCells = this.getLeafNodes(this.attrs.xaxis);
			for(var i =0;i<xaxisCells.length;i++){
				var node=xaxisCells[i];
				node.children=[{"id":"","text":this.getAscStringByNumber(i)}];
			}
			var yaxisCells = this.getLeafNodes(this.attrs.yaxis);
			for(var i =0;i<yaxisCells.length;i++){
				var node=yaxisCells[i];
				node.children=[{"id":"","text":(i+1)}];
			}
		},
		getLeafNodes:function (node){
			var cells=[];
			var children = node.children;
			if( children && children.length ){
				for(var i =0;i<children.length;i++){
					var value=children[i];
					var cell = this.getLeafNodes(value);
					cells = cells.concat( cell );
				}
			}else{
				cells.push( node );
			}
			return cells;
		},
		setRowColumnLevel:function (node,type){
			var row= 0;
			var column= 0;
			var level= 1;
			var children = node.children;
			if( children ){
				for(var i =0;i<children.length;i++){
					var child = children[i];
					child = this.setRowColumnLevel(child,type);
					if( 1+child.level > level ){
						level = 1+child.level;
					}
					if("X"==type){// X轴
						column= column+child.column;
					}else if("Y"==type){// Y轴
						row= row+child.row;
					}
				}
			}
			node.level= level;
			node.row= row || 1;
			node.column= column || 1;
			return node;
		},
		drawTitle:function (row,col,name){
			var html="";
			html+="<td class='tblReport_msg' rowspan='"+row+"'  colspan='"+col+"' >" ;
			html+="	<div class='tblReport_msg_div'><ul><li class='tblReport_msg_logo'></li>";
			html+="		<ul>";
			html+="			<li class='tblReport_msg_logo'></li>";
			html+="			<li class='tblReport_msg_con'>"+name+"</li>";
			html+="		</ul>";
			html+="	</div>";
			html+="</td>";
			return html;
		},
		drawXAxis:function (node,x_level,y_level){
			var html="";
			x_level--;
			y_level--;
			for(var i = x_level ; i>0  ;i--){
				if(i==x_level){
					html+="<tr class='tr_title tr_xaxis'>";
					html+=this.drawTitle(x_level,y_level,this.attrs.title.text);
				}else{
					html+="<tr class='tr_xaxis'>";
				}
				var t = this.drawXAxisTd(node,i);
				html+=t;
				html+="</tr>";
			}
			return html;
		},
		drawXAxisTd:function (tree,level){
			var html="";
			var nodes = this.getSpecifyLevelNodes(tree,level);
			var beginIndex=0;
			var startIndex=1;
			var endIndex=1;
			for(var i=0;i<nodes.length;i++ ){
				var cell = nodes[i];
				var id = cell.id;
				var text = cell.text;
				var row = cell.row;
				var column = cell.column;
				var appendField="";
				if(this.attrs.splitTable){
					endIndex=startIndex+column-1;
					appendField=" xaxisindex='"+startIndex+"' startxaxisindex='"+startIndex+"'  endxaxisindex='"+endIndex+"' ";
					startIndex=startIndex+column;
				}
				html+="<td class='tblReport_title xtitle' id='"+id+"' rowspan='"+row+"'  colspan='"+column+"' "+appendField+" >"+text+"</td>";
				if( cell.isLeaf ){
					for(var j=beginIndex;j<beginIndex+column;j++){
						var temp = this.attrs.xaxisLeafNodeIdArr[j];
						if( !temp ){
							temp=this.attrs.xaxisLeafNodeIdArr[j]=[];
						}
						temp.push(id);
					}
					beginIndex+=column;
				}
			}
			return html;
		} ,
		getSpecifyLevelNodes:function (node,level){
			var nodes=[];
			if(node.level==level){
				nodes.push( node );
			}else if(node.level>level){
				var children = node.children;
				if( children && children.length ){
					for(var i=0;i< children.length;i++){
						var child=children[i];
						var cnodes = this.getSpecifyLevelNodes(child,level);
						nodes = nodes.concat( cnodes );
					}
				}
			}
			return nodes;
		},
		drawYAxis:function (tree,x_column,y_row){
			var html="";
			for(var i=0;i<y_row;i++){
				html+="<tr class='tr_yaxis'>";
				html+= this.drawYAxisTd( tree,i );
				if( tree.children[0] && tree.children[0].row==0 ){
					tree.children.splice(0,1);
				}
				html+=this.drawCell(i,x_column);
				html+="</tr>";
			}
			return html;
		} ,
		drawYAxisTd:function ( tree,rowIndex ){
			var html="";
			if( !tree.isDraw && !tree.isRoot){
				var id = tree.id;
				var text = tree.text;
				var row = tree.row;
				var column = tree.column;
				html+="<td class='tblReport_title ytitle' id='"+id+"' rowspan='"+row+"'  colspan='"+column+"' >"+text+"</td>";
				tree.isDraw=true;
			}
			if( tree.isLeaf ){
				var id = tree.id;
				var temp = this.attrs.yaxisLeafNodeIdArr[rowIndex];
				if( !temp ){
					temp=this.attrs.yaxisLeafNodeIdArr[rowIndex]=[];
				}
				temp.push(id);
			}
			var children = tree.children;
			if( children && children.length ){
				var child = children[0];
				var t = this.drawYAxisTd( child,rowIndex );
				if( child.row==0 ){
					tree.children.splice(0,1);
				}
				html+=t;
			}
			tree.row = tree.row-1 ;
			return html;
		} ,
		drawCell:function (rowIndex,x_column){
			var html="";
			var y= this.attrs.yaxisLeafNodeIdArr[rowIndex] && this.attrs.yaxisLeafNodeIdArr[rowIndex].join( this.attrs.joinString );
			for(var j =0;j<x_column;j++){
				var x = this.attrs.xaxisLeafNodeIdArr[j] && this.attrs.xaxisLeafNodeIdArr[j].join( this.attrs.joinString );
				html+="<td x='"+x+"' y='"+y+"'  yaxis='"+(rowIndex+1)+"' xaxis='"+this.getAscStringByNumber(j)+"' xaxisindex='"+(j+1)+"' class='editTd' ></td>";
			}
			return html;
		} ,
		getAscStringByNumber:function (number){
			number=parseInt(number);
			var temp2=parseInt(number/26);
			var value = "";
			if( temp2>0 ){
				value = this.getAscStringByNumber(temp2-1);
			}
			var temp3=parseInt(number%26);
			v1="A";
			var t4=v1.charCodeAt()+temp3;
			v1 = String.fromCharCode(t4);
			return value+v1;
		},
		initializeAttrs: function(config) {
			this.attrs = $.extend( true ,{}, this.attrs ,config );
			this.attrs.xaxis={"children":config.xaxis};
			this.attrs.yaxis={"isRoot":true,"children":config.yaxis};
			this.attrs.hasAxis && this.addAxis();
			this.setRowColumnLevel(this.attrs.xaxis,"X");
			this.setRowColumnLevel(this.attrs.yaxis,"Y");
			this.attrs.xaxisLeafNodeIdArr=[];
			this.attrs.yaxisLeafNodeIdArr=[];
		},
		initialize:function (cfg){
			this.initializeAttrs(cfg);
			var xAxis=this.attrs.xaxis;
			var yAxis=this.attrs.yaxis;
			var x_level  =xAxis.level;
			var x_column =xAxis.column;
			var y_level  =yAxis.level;
			var y_row =yAxis.row;
			
			var html="";
			html += this.drawXAxis(xAxis,x_level,y_level);
			html += this.drawYAxis(yAxis,x_column,y_row);
			
			if( this.attrs.splitTable ){
				this.splitTable( y_level,x_column,html );
			}else{
				html = "<table class='tblReport tblReportContent' >"+html+"</table>";
				this.attrs.content.children().remove();
				this.attrs.content.append( '<div><span class="rTitle">'+this.attrs.tableTitle+'</span></div><div class="rcontent" ></div>' );
				var rcontent = this.attrs.content.find(".rcontent");
				rcontent.html( html );
				var rtile = this.attrs.content.find(".rTitle");
				var marginleft = (rcontent.width()-rtile.width())/2;
				if(marginleft<0){
					marginleft=0;
				}
				rtile.css("marginLeft", marginleft +"px" );
				if( this.attrs.congelationTitle){
					this.congelationTitle( html );
				}
			}
			if( this.attrs.successCallBack ){
				this.attrs.successCallBack.apply(window);
			}
			
		},
		splitTable:function(y_level,x_column,html){
			var zcol=this.attrs.splitTableColSize;
			y_level--;
			var col= x_column+y_level;
			var col1=zcol-y_level;
			
			var tablecol=x_column+y_level;
			var tablecount = 1;
			if(tablecol>zcol){
				tablecount = x_column/col1;
			}
			this.attrs.content.find("table").remove();
			for(var i=1;i<tablecount+1;i++){
				var tableId=this.attrs.tableId;
				var title ="";
				tableId=this.attrs.tableId+ new Date().getTime() +'_'+i;
				title=this.attrs.splitTableString+i;
				var tablehtml='<table class="tblReport" id="'+tableId+'" >'+html+'</table>';
				this.attrs.content.append( tablehtml );
				var table= $("#"+tableId);
				title = table.find(".tblReport_msg_con").html()+title;
				table.css("table-layout","fixed");
				table.css("zoom","0.5");
				if(i>=tablecount){
					tablecol=col-(i-1)*col1;
				}else{
					tablecol=zcol;
				}
				
				var tds = table.find("td");
				for(var len=tds.length-1;len>=0;len--){
					var td=$(tds[len]);
					var xaxisindex = td.attr("xaxisindex");
					if( xaxisindex ){
						var colspan = parseInt( td.attr("colspan") );
						if(  colspan > 1 ){
							var startxaxisindex = td.attr("startxaxisindex");
							var endxaxisindex = td.attr("endxaxisindex");
							startxaxisindex = parseInt(startxaxisindex);
							endxaxisindex = parseInt(endxaxisindex);
							if( endxaxisindex <= (i-1)*col1 ){
								td.remove();
							}else if( endxaxisindex <= i*col1 ){
								if( startxaxisindex <= (i-1)*col1 ){
									td.attr("colspan", ( endxaxisindex-(i-1)*col1) );
								}else if( startxaxisindex > (i-1)*col1 ){
									td.attr("colspan", (endxaxisindex-startxaxisindex+1) );
								}
							}else if( endxaxisindex > i*col1 ){
								if( startxaxisindex <= (i-1)*col1 ){
									td.attr("colspan",col1);
								}else if( startxaxisindex <= i*col1 ){
									td.attr("colspan", (i*col1-startxaxisindex+1) );
								}else if( startxaxisindex > i*col1 ){
									td.remove();
								}
							}
						}else{
							xaxisindex = parseInt(xaxisindex);
							if(  !( xaxisindex>(i-1)*col1 && xaxisindex<=i*col1 )  ){
								td.remove();
							}
						}
					}
					
				}
			}
		},
		congelationTitle:function( html ){
			var pcontent = this.attrs.content;
			var parent = pcontent.find(".rcontent");
			parent.css( {overflowY:"auto",overflowX:"auto",position:"relative",zIndex:"1003"} );
			var pwidth = this.attrs.width;
			var pheight = this.attrs.height;
			if( !pwidth ){
				var wwidth=$(window).width();
				var wheight=$(window).height();
				var offset = parent.offset();
				pwidth = wwidth-offset.left;
				pheight = wheight-offset.top-50;
			}
			parent.css( {width: (pwidth+"px"),height: (pheight+"px") } );
			var table = parent.find("table").eq(0);
			
			parent.append( html );
			var title = parent.find("table").eq(1);
			var tr_title = title.find(".tr_title");
			title.find("tr").not( tr_title ).remove();
			tr_title.find(".xtitle").remove();
			title.removeClass("tblReportContent");
			
			parent.append( html );
			var xtitle = parent.find("table").eq(2);
			var tr_xaxis = xtitle.find(".tr_xaxis");
			xtitle.find("tr").not( tr_xaxis ).remove();
			tr_xaxis.find(".tblReport_msg").remove();
			xtitle.removeClass("tblReportContent");
			
			parent.append( html );
			var ytitle = parent.find("table").eq(3);
			var tr_yaxis = ytitle.find(".tr_yaxis");
			ytitle.find("tr").not( tr_yaxis ).remove();
			tr_yaxis.find(".editTd").remove();
			ytitle.removeClass("tblReportContent");
			
			title.css({"position":"absolute","z-index":1002,"top":"0px","left":"0px"});
			xtitle.css({"position":"absolute","z-index":1001});
			ytitle.css({"position":"absolute","z-index":1001});
			
			var width = table.find(".tblReport_msg").width() ;
			var height = table.find(".tblReport_msg").height() ;
			width++;
			height++;
			title.find(".tblReport_msg").width( width );
			title.find(".tblReport_msg").height( height );
			pright= parseInt(table.find(".tblReport_msg").css("padding-right").split("px")[0]);
			pleft= parseInt(table.find(".tblReport_msg").css("padding-left").split("px")[0]);
			xtitle.css({"top":"0px","left":(width+pright+pleft)+"px"});
			ytitle.css({"top":height+"px","left":"0px"});
			if( pwidth ){
				this.bindScrollEvent( parent ,title,xtitle,ytitle,width+pright+pleft,height);
			}
		},
		bindScrollEvent:function(parent,title,xtitle,ytitle,width,height,rtile){
			parent.scroll(function(){
				var scrollTop = parent.scrollTop();
				var scrollLeft = parent.scrollLeft();
				title.css({"top":scrollTop+"px","left":scrollLeft+"px"});
				xtitle.css({"top":scrollTop+"px","left":width+"px"});
				ytitle.css({"top":height+"px","left":scrollLeft+"px"});
			});
		}

	};
	
	module.exports = Class.extend( Table );

});

define("inno/en/table/1.0/table2",function(require, exports, module){
	var $=require("$");
	var Table=require("./table");
	var Class=require("class");

	var Table2={
		attrs:{
			xaxis:[],
			yaxis:[],
	        title:{},
	        imetaFieldCfg:{"imetaId":"id","iname":"text"},        
			icmetaFieldCfg:{"id":"id","text":"text"}    ,
			displayType:"CC",
			table:null,
		},
		initialize: function(config) {
			this.attrs = $.extend( true ,{}, this.attrs ,config );
			if(config.imetaFieldCfg){
				this.attrs.imetaFieldCfg=config.imetaFieldCfg;
			}
			if(config.icmetaFieldCfg){
				this.attrs.icmetaFieldCfg=config.icmetaFieldCfg;
			}
			this.changeFieldName(this.attrs.yaxis,this.attrs.icmetaFieldCfg);
			if(this.attrs.displayType=="CC"){
				this.changeFieldName(this.attrs.xaxis,this.attrs.icmetaFieldCfg);
				this.changeFieldName([this.attrs.title],this.attrs.imetaFieldCfg);
			}else if(this.attrs.displayType=="CI"){
				this.changeFieldName(this.attrs.xaxis,this.attrs.imetaFieldCfg);
			}
			this.fillNode( );
			this.attrs.table = new Table( this.attrs );
			var table = this.attrs.table.attrs.content;;
			var tds = table.find(".editTd");
			for(var i=0;i<tds.length;i++){
				var td=$(tds[i]);
				var y= td.attr("y");
				var gid = y ;
				if("CC"==this.attrs.displayType){
					var x= td.attr("x");
					gid += "AND"+ x;
				}
				td.attr("gid",gid);
			}
		},
		changeFieldName:function( obj, cfg ,childrenField){
			childrenField = childrenField || "children";
			if(obj && obj.length){
				for(var i=0;i<obj.length;i++){
					var node = obj[i];
					for(var ofield in node ){
						var nfield = cfg[ofield];
						if(nfield == ofield){
							continue;
						}
						var value = node[ofield];
						if(ofield==childrenField && value){
							this.changeFieldName( value, cfg ,childrenField);
							nfield = nfield || "children";
						}
						delete node[ofield];
						node[nfield]=value;
					}
				}
			}
		},
		fillNode:function (){
			for(var i=0;i<this.attrs.xaxis.length;i++){
				var node = this.attrs.xaxis[i];
				this.fillTree( node, this.getLevel( node ) );
			}
			for(var i=0;i<this.attrs.yaxis.length;i++){
				var node = this.attrs.yaxis[i];
				this.fillTree( node, this.getLevel( node ) );
			}
			for(var i=this.attrs.yaxis.length-1;i>0;i--){
				this.superposition(this.attrs.yaxis[i-1],this.attrs.yaxis[i]);
				this.attrs.yaxis.splice(i,1);
			}
			if(this.attrs.displayType=="CC"){
				for(var i=this.attrs.xaxis.length-1;i>0;i--){
					this.superposition(this.attrs.xaxis[i-1],this.attrs.xaxis[i]);
					this.attrs.xaxis.splice(i,1);
				}
			}
			
		},
		superposition:function (node1,nodd2){
			var leftnode = Table.prototype.getLeafNodes(node1);
			for(var i in leftnode){
				var value1=leftnode[i];
				value1.children = [];
				if(nodd2.children){
					var leafNode2=$.extend(true,{},nodd2);
					value1.children = value1.children.concat( leafNode2 );
				}
			}
			return node1;
		},
		getLevel:function (node){
			var level= 1;
			var nodes = node.children;
			if( nodes && nodes.length){
				for(var i =0;i<nodes.length;i++){
					var child = nodes[i];
					childLevel = this.getLevel(child);
					if( 1+childLevel > level ){
						level = 1+childLevel;
					}
				}
			}
			return level;
		},
		fillTree:function (node,level){
		    var children = node.children;
			if( children && children.length ){
				for(var i=0;i<children.length;i++){
					var t = level-1;
					this.fillTree(children[i],t);
				}
			}else{
				level--;
				if( level ){
					node.children = [ this.creatNullNode(level,node.id) ] ;
				}else{
					node.isLeaf=true; // 叶子节点
				}
			}
		},
		creatNullNode:function (level,id){
			var node = {"id":"","text":""};
			level--;
		    if(level){
		    	node.children = [ this.creatNullNode(level,id) ];
		    }else{
		    	node.isLeaf=true; // 叶子节点
		    	node.id=id;
		    }
		    return node;
		},
		
	};
	
	module.exports = Class.extend( Table2 );
	
});



define("inno/en/table/1.0/table-debug",function(require,exports, module){
	var $=require("$");
	var Table=require("./table");
	var Table2=require("./table2");
	var Class=require("class");
	
	Bill={
		attrs:{
			xaxis:[],	
			yaxis:[],	
			title: {},
			icmeta:[],
			icmetaId:"id",
			imeta:[],
			layoutCfg:{},
			tableId:"",
			displayType:"",
			content:$("#table"),
			hasAxis:true,
			splitTable:false,
			splitTableColSize:7,
			congelationTitle:true,
			width:null,
			height:null,
			isShowData:false,
			beforeCallBack:function( attr ){
				if("CC"==attr.layoutCfg.displayType){
					var title = attr.title;
					var x= attr.xaxis;
					for(var j =0;j< x.length;j++){
						var xnode = x[j];
						var nodes = Table.prototype.getLeafNodes( xnode );
						var iunit = title.iunit;
						for(var i =0;i< nodes.length;i++){
							if("CC"==attr.layoutCfg.displayType){
								var title = attr.title;
								var x= attr.xaxis;
								for(var j =0;j< x.length;j++){
									var xnode = x[j];
									var nodes = Table.prototype.getLeafNodes( xnode );
									var iunit = title.iunit;
									for(var i =0;i< nodes.length;i++){
										var node = nodes[i];
										if( node.text ){
											var text = node.text;
											if(text.indexOf("亿立方米")>=0){
												if( iunit == "TJ" || iunit == "吨碳/TJ" || iunit == "%" ){
													text = text.replace("亿立方米",iunit);
												}else if( iunit == "KJ/KG" ){
													text = text.replace("亿立方米","KJ/亿立方米");
												}else if( iunit == "TJ/万t" ){
													text = text.replace("亿立方米","TJ/亿立方米");
												}else if(title.iname == "CO2(万吨)"){
													text = text.replace("亿立方米","万吨");
												}
											}else if(text.indexOf("百万千焦")>=0){
												if( iunit == "TJ" || iunit == "吨碳/TJ" || iunit == "%" ){
													text = text.replace("百万千焦",iunit);
												}else if( iunit == "TJ/万t" ){
													text = text.replace("百万千焦","TJ/百万千焦");
												}else if(title.iname == "CO2(万吨)"){
													text = text.replace("百万千焦","万吨");
												}
											}else if(text.indexOf("万kWh")>=0){
												if( iunit == "TJ" || iunit == "吨碳/TJ" || iunit == "%" ){
													text = text.replace("万kWh",iunit);
												}else if( iunit == "TJ/万t" ){
													text = text.replace("万kWh","TJ/万kWh");
												}else if(title.iname == "CO2(万吨)"){
													text = text.replace("万kWh","万吨");
												}
											}else if(text.indexOf("kg/TJ")>=0){
												if( iunit == "吨" ){
													text = text.replace("kg/TJ",iunit);
												}else if( iunit == "万吨" ){
													text = text.replace("kg/TJ","TJ");
												}
											}else{
												text+="("+iunit+")";
											}
											node.text = text ;
										}
									}
								}
							}
						}
					}
				}
			}
		},
		initialize:function( config ){
			this.attrs = $.extend( true ,{}, this.attrs ,config );
			this.getLayoutCfg();
			this.getImeta();
			this.getIcmeta();
		},
		show:function(){
			var attrs= this.attrs;
			var imeta = attrs.imeta;
			var icmeta = attrs.icmeta;
			var layoutCfg = attrs.layoutCfg;
			
			attrs.xaxis=[];
			attrs.yaxis=[];
			attrs.title={};
			if( !(icmeta.length && imeta.length && layoutCfg.ys) ){
				return ;
			}
			attrs.displayType  = layoutCfg.displayType;
//			if( !attrs.displayType ){
//				attrs.displayType  = layoutCfg.displayType;
//			}
			if( attrs.tableTitle===false ){
				attrs.tableTitle = "";
			}else{
				if( !attrs.tableTitle ){
					attrs.tableTitle  = layoutCfg.title;
				}
			}
			var xAxis = [];
			if( attrs.displayType=="CC" ){
				xAxis =  layoutCfg.xs.split(",");
			}else{
				xAxis =  layoutCfg.icIds.split(",");
			}
			if( attrs.displayType=="CC" ){
				for(var i=0;i<xAxis.length;i++){
					var tempid = xAxis[i];
					for(var j=0;j<icmeta.length;j++){
						if(tempid==icmeta[j][attrs.icmetaId]){
							attrs.xaxis.push( icmeta[j] );
						}
					}
				}
				attrs.title= $.extend(true,{},imeta[0]);
				if(attrs.title.iunit){
					attrs.title.iname = attrs.title.iname + "("+attrs.title.iunit+")";
				}
			}else if( attrs.displayType=="CI" ){
				for(var i=0;i<xAxis.length;i++){
					var tempid = xAxis[i];
					for(var j=0;j<imeta.length;j++){
						if(tempid==imeta[j].imetaId){
							newImeta= $.extend(true,{},imeta[j]);
							if(imeta[j].iunit){
								newImeta.iname = imeta[j].iname + "("+imeta[j].iunit+")";
							}
							attrs.xaxis.push( newImeta );
						}
					}
				}
			}
			
			var yAxis = attrs.layoutCfg.ys.split(",");
			for(var i=0;i<yAxis.length;i++){
				var tempid = yAxis[i];
				for(var j=0;j<icmeta.length;j++){
					if(tempid==icmeta[j][attrs.icmetaId]){
						attrs.yaxis.push( icmeta[j] );
					}
				}
			}
			if( this.attrs.beforeCallBack ){
				try{
					this.attrs.beforeCallBack.call(window,attrs);
				}catch(e){
					console.log( e );
				}
			}
			this.attrs.table2 = new Table2( attrs );
			var isShowData = this.attrs.isShowData;
			if(isShowData){
				this.getValue();
			}
		},
		setIcmeta:function(icmeta,cfg){
			$.extend( true , this.attrs ,cfg );
			this.attrs.icmeta=icmeta;
			this.show();
		},
		setGlobalRmodel:function(icmeta,imeta,layoutCfg){
			if(icmeta){
				this.attrs.icmeta=icmeta;
			}
			if(imeta){
				this.attrs.imeta=imeta;
			}
			if(layoutCfg){
				this.attrs.layoutCfg=layoutCfg;
			}
			this.show();
		},
		getIcmeta:function(){
			var _this = this;
			var parameter={
			     url:"bill/common/get/icmeta/instance",
			     data:{ rmodelId : _this.attrs.tableId },
			     success:function(data){
			    	 _this.attrs.icmeta=data;
			    	 _this.show();
			     }
			};
			$.ajax( parameter );
		},
		getValue:function(){
			var _this = this;
			var parameter={
			     url:"bill/common/get/value",
			     data:{ rmodelId : _this.attrs.tableId },
			     success:function(data){
			    	 _this.showValue(data);
			     }
			};
			$.ajax( parameter );
		},
		getTableContent:function(){
			return this.attrs.content;
		},
		toRound:function(num,digit){
		    with(Math){  
		        return round(num*pow(10,digit))/pow(10,digit);  
		    }  
		},
		showValue:function(data){
			for ( var int = 0; int < data.length; int++) {
				var o = data[int];
				var sign= o.inputOrCalSign;//填写或者公式标识
				var rid=o.riCMapModelId;//单元格ID
				var gid=o.icDetailIdGroup;//维度组合
				var comment=o.icValueComment || "";//单元格备注信息
				if(comment=="null"){
					comment="";
				}
				id = gid.replace(/></g,"AND");
				id = id.substr(1);
				id = id.substr(0,id.length-1);
				id = id.split("|").join('\\|');
				id = id.split("(").join('\\(');
				id = id.split(")").join('\\)');
				var td;
				if( this.attrs.displayType=="CI"){
					var imetaId=o.imetaId;
					td= this.getTableContent().find("td[gid="+id+"][x="+imetaId+"]");
				}else{
					td= this.getTableContent().find("td[gid="+id+"]");
				}
				td.attr("icid",rid);
				var val=o.icValue || "";
				if(val.indexOf(".")==0){
					val="0"+val;
				}
				if(val.indexOf("-.")==0){
					val="-0"+val.substring(1);
				}
				var tdclass = "";
				if("CAL"==sign){
					td.attr("title",val);
					if(val != ""){
						val = this.toRound(val, 4);
					}
					td.attr("rid",rid);
					td.attr("sign",sign);
					tdclass="calTd";
				}else if("INPUT"==sign){
					var x=td.attr("xaxis");
					var y=td.attr("yaxis");
					var splitTable = this.attrs.splitTable;
					if(!splitTable){
						val="<ul class=\"inputli\"><li class=\"inputtext\"><input style = 'width:100%;border:none'  txy='"+x+""+y+"' class='edit' value='"+val+"' edvalue='"+val+"' /></li>";
						val = val + "</ul>";
					}
				}else if("Lock"==sign){
					td.attr("title","该单元格已被锁住无法录入数据");
					val="";//LOCK不显示
					td.attr("rid",rid);
					td.attr("sign",sign);
					tdclass="Lock";
				}
				td.html(val);
				td.addClass(tdclass);
			};
		},
		getImeta:function(){
			var _this = this;
			var parameter={
			     url:"bill/common/get/imeta/instance",
			     data:{ rmodelId : _this.attrs.tableId },
			     success:function(data){
			    	 _this.attrs.imeta=data;
			    	 _this.show();
			     }
			};
			$.ajax( parameter );
		},
		getLayoutCfg:function(){
			var _this = this;
			var parameter={
				 url:"bill/common/get/layout",
			     type:"POST",
			     data:{ rmodelId : _this.attrs.tableId },
			     success:function(data){
			    	 _this.attrs.layoutCfg=data;
			    	 _this.show();
			     }
			};
			$.ajax( parameter );
		},
	};
	
	module.exports =  Class.extend( Bill ); 

});





