define(function(require) {
    var $ = require('$');
    // 兼容placeholder
    $(function(){
        if( !('placeholder' in document.createElement('input')) ){   
            $('.ipt-placeholder').each(function(){    
                var that = $(this),    
                text= that.attr('placeholder');    
                if(that.val()===""){    
                   that.val(text).addClass('placeholder');    
                }    
                that.focus(function(){    
                   if(that.val()===text){    
                        that.val("").removeClass('placeholder');    
                    }    
                })    
                .blur(function(){    
                   if(that.val()===""){    
                        that.val(text).addClass('placeholder');    
                   }    
                });    
            });  
        }
    });
    
});