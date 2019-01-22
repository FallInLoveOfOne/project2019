<%--
  Created by IntelliJ IDEA.
  User: SYY
  Date: 2018/9/17
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:v="urn:schemas-microsoft-com:vml"
      xmlns:o="urn:schemas-microsoft-com:office:office"
      xmlns:w="urn:schemas-microsoft-com:office:word"
      xmlns:m="http://schemas.microsoft.com/office/2004/12/omml"
      xmlns="http://www.w3.org/TR/REC-html40">

<head>
    <meta http-equiv=Content-Type content="text/html; charset=unicode">
    <meta name=ProgId content=Word.Document>
    <meta name=Generator content="Microsoft Word 15">
    <meta name=Originator content="Microsoft Word 15">
    <link rel=File-List href="三垟戒毒所防错放系统接口文档_20180904.files/filelist.xml">

    <link rel=themeData href="三垟戒毒所防错放系统接口文档_20180904.files/themedata.thmx">
    <link rel=colorSchemeMapping
          href="三垟戒毒所防错放系统接口文档_20180904.files/colorschememapping.xml">

    <style>
        html {
            font-family: 宋体
        }
    </style>

</head>

<body lang=ZH-CN style='tab-interval:21.0pt;margin: 0px;'>

<div class=WordSection1
     style="margin: 20px;padding: 20px;background-color: #fff;box-shadow: 0 0 10px rgba(16, 50, 85, 0.1);">

    <h1 style='margin: 0px;'><span lang=EN-US>1</span>、默认页面</h1>
    <div style='margin-left:15.0pt'>

        <p>欢迎使用<span lang=EN-US>Sho</span></p>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
        </p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l35 level1 lfo1;tab-stops:list 36.0pt'>用户注册接口
            </li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                lang=EN-US>URL</span>：</span></strong></p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l41 level1 lfo2;tab-stops:list 36.0pt'><code><span
                    lang=EN-US>http://xx.com/api/user/register</span></code></li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l3 level1 lfo3;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
        </p>

        <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
               style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
            <thead>
            <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                    </p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal align=center style='text-align:center'><b><span
                            style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
            </tr>
            </thead>
            <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal>是</p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><span lang=EN-US>string</span></p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal>报告类型</p>
                </td>
            </tr>
        </table>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

        <p><span lang=EN-US>{total: 22, rows: [ {report_id: &quot;xx&quot;,
report_name: &quot;xx&quot;, report_date: &quot;xx&quot;}, {report_id:
&quot;xx&quot;, report_name: &quot;xx&quot;, report_date: &quot;xx&quot;} ] }</span></p>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
        </p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l5 level1 lfo4;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
            </li>
        </ul>

        <p><span lang=EN-US>wDoc</span>！</p>

    </div>

    <h1><span lang=EN-US>2</span>、首页</h1>

    <h1><span lang=EN-US>3</span>、出所管理</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>3.1</span>、添加出所节点记录</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l56 level1 lfo5;tab-stops:list 36.0pt'>添加出所节点记录（服务层）
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>personNumber</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>name</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员名称</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>items</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>节点事项</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.2</span>、出所单文件上传</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l20 level1 lfo6;tab-stops:list 36.0pt'>出所单文件上传
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l29 level1 lfo7;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/upload/outList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l27 level1 lfo8;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>包含<span lang=EN-US>form</span>表单文件请求</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.3</span>、同步近一周出所戒毒人员数据</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l7 level1 lfo9;tab-stops:list 36.0pt'>同步人员数据到本地库
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l24 level1 lfo10;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/synchroPersonData</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l1 level1 lfo11;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endData</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>出所日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>days</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>近多少天（例如近一周）</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong></p>

        </div>

        <h2><span lang=EN-US>3.4</span>、同步人员照片</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l0 level1 lfo12;tab-stops:list 36.0pt'>同步人员照片（服务层）
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功；<span lang=EN-US>false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l45 level1 lfo13;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.5</span>、正常出所人员分页</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l49 level1 lfo14;tab-stops:list 36.0pt'>正常出所人员分页
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l55 level1 lfo15;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/normalPage</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l43 level1 lfo16;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'> </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l25 level1 lfo17;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.6</span>、临时出所出所人员分页</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l46 level1 lfo18;tab-stops:list 36.0pt'>临时出所出所人员分页
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l16 level1 lfo19;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/temporaryPage</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l4 level1 lfo20;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'> </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.7</span>、查询出所人员详情信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l47 level1 lfo21;tab-stops:list 36.0pt'>查询出所人员详情信息
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l36 level1 lfo22;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxxx/release/outPersonDetails</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l31 level1 lfo23;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;id&quot;: xxxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;name&quot;:xxxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>......<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>  </span>}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>Map</span></p>
                        <String
                                , Object>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员详情信息</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l48 level1 lfo24;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.8</span>、出所头像核对</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l19 level1 lfo25;tab-stops:list 36.0pt'>出所头像核对
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l38 level1 lfo26;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/headPhotoCheck</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l42 level1 lfo27;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

    </div>

    <h1><span lang=EN-US>4</span>、存证管理</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>4.1</span>、出所单文件下载</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l15 level1 lfo28;tab-stops:list 36.0pt'>出所单文件下载
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l50 level1 lfo29;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/download/outList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l53 level1 lfo30;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span>请求</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>response</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletResponse</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>response</span>响应</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>id</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>附件<span lang=EN-US>id</span></p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>void</span></p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.2</span>、查询出所节点所记录信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l39 level1 lfo31;tab-stops:list 36.0pt'>查询出所节点所记录信息<span
                        lang=EN-US>(</span>服务层<span lang=EN-US>)</span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>name</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员名称</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>[{CREATE_TIME: &quot;</span>创建时间<span
                            lang=EN-US>1&quot;, UPDATE_TIME: &quot;</span>更新时间<span
                            lang=EN-US>1&quot;, ITEM: &quot;</span>事项<span
                            lang=EN-US>1&quot;}, {CREATE_TIME: &quot;</span>创建时间<span lang=EN-US>2&quot;, UPDATE_TIME: &quot;</span>更新时间<span
                            lang=EN-US>2&quot;, ITEM: &quot;</span>事项<span lang=EN-US>2&quot;},...]</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>List&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>节点记录集合</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.3</span>、查询存证人员详情信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l28 level1 lfo32;tab-stops:list 36.0pt'>查询存证人员详情信息
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l9 level1 lfo33;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/evidencePersonDetails</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l6 level1 lfo34;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;id&quot;: xxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;name&quot;: xxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>.....<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>  </span>}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>Map</span></p>
                        <String
                                , Object>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员详情信息</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.4</span>、存证管理分页查询</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l8 level1 lfo35;tab-stops:list 36.0pt'>存证管理分页查询
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l32 level1 lfo36;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/evidencePageList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l57 level1 lfo37;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.5</span>、出所单文件上传</h2>

        <div style='margin-left:15.0pt'>

            <p>说明：此接口与出所管理同一接口</p>

        </div>

    </div>

    <h1><span lang=EN-US>5</span>、统计报告</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>5.1</span>、统计报告分页</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l18 level1 lfo38;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l13 level1 lfo39;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xx.com/api/user/register</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l12 level1 lfo40;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>报告类型</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><span lang=EN-US>{total: 22, rows: [{ID: “33”, createtime: “ss”, reportName:
“ss”}, {ID: “22”, createtime: “ss”, reportName: “ss“}]}</span></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US> **</span>备注<span lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>- </span>更多返回错误代码请看首页的错误代码描述</code></pre>
                    </td>
                </tr>
            </table>

        </div>

        <h2><span lang=EN-US>5.2</span>、统计<span lang=EN-US>echarts</span>展示</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l11 level1 lfo41;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xx.com/api/user/register</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l40 level1 lfo42;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>报告类型</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><span lang=EN-US>`[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;] [100,200,300] </span></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US> **</span>返回参数说明<span lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>|</span>参数名<span
                                lang=EN-US>|</span>类型<span lang=EN-US>|</span>说明<span lang=EN-US>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>|:-----<span
                                style='mso-spacerun:yes'>  </span>|:-----|-----<span style='mso-spacerun:yes'>                           </span>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>| |</span>数组<span
                                lang=EN-US><span style='mso-spacerun:yes'>   </span>|key-value<span
                                style='mso-spacerun:yes'>  </span>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US> **</span>备注<span
                                lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US>- </span>更多返回错误代码请看首页的错误代码描述</code></pre>
                    </td>
                </tr>
            </table>

        </div>

    </div>

    <h1><span lang=EN-US>6</span>、数据接口</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>6.1</span>、记录数据接口调用日志</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l22 level1 lfo43;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l14 level1 lfo44;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/logsDataInteCall</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l34 level1 lfo45;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>interfaceName</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>用户名</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>url</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>请求路径</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>callModule</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用模块</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:4;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>callTime</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用时间</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l26 level1 lfo46;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.2</span>、查询各接口调用数量占比</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l30 level1 lfo47;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l37 level1 lfo48;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getInterfaceCallRatio</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l44 level1 lfo49;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>echarts</span>返回规范</code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong><span
                    lang=EN-US> | echarts</span>返回规范</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l33 level1 lfo50;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.3</span>、查询所有数据接口的调用信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l21 level1 lfo51;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l2 level1 lfo52;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getDataInteCallInfo</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l51 level1 lfo53;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>[<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>     </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'INTERFACE_NAME':'</span>查询拘留所人员信息<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'URL':'http://xxx',<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_MODULE':'</span>待出所人员管理<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_TIME':'2018-03-11 18:32:32'<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>},<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>     </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'INTERFACE_NAME':'</span>查询拘留所人员信息<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'URL':'http://xxx',<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_MODULE':'</span>待出所人员管理<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_TIME':'2018-03-11 18:32:32'<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>},<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>]</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].INTERFACE_NAME</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>接口名称</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].URL</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>请求路径</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].CALL_MODULE</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用模块</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:4;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].CALL_TIME</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用时间</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l23 level1 lfo54;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.4</span>、查询每日接口调用频率</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l10 level1 lfo55;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l54 level1 lfo56;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getDailyInteCallFreq</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l52 level1 lfo57;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>echarts</span>返回规范</code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <p><span lang=EN-US>echarts</span>返回规范</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l17 level1 lfo58;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

    </div>

    <h1><span lang=EN-US>7</span>、系统管理</h1>

</div>

</body>

</html>
<html xmlns:v="urn:schemas-microsoft-com:vml"
      xmlns:o="urn:schemas-microsoft-com:office:office"
      xmlns:w="urn:schemas-microsoft-com:office:word"
      xmlns:m="http://schemas.microsoft.com/office/2004/12/omml"
      xmlns="http://www.w3.org/TR/REC-html40">

<head>
    <meta http-equiv=Content-Type content="text/html; charset=unicode">
    <meta name=ProgId content=Word.Document>
    <meta name=Generator content="Microsoft Word 15">
    <meta name=Originator content="Microsoft Word 15">
    <link rel=File-List href="三垟戒毒所防错放系统接口文档_20180904.files/filelist.xml">

    <link rel=themeData href="三垟戒毒所防错放系统接口文档_20180904.files/themedata.thmx">
    <link rel=colorSchemeMapping
          href="三垟戒毒所防错放系统接口文档_20180904.files/colorschememapping.xml">

    <style>

    </style>

</head>

<body lang=ZH-CN style='tab-interval:21.0pt'>

<div class=WordSection1>

    <h1><span lang=EN-US>1</span>、默认页面</h1>

    <div style='margin-left:15.0pt'>

        <p>欢迎使用<span lang=EN-US>Sho</span></p>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
        </p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l35 level1 lfo1;tab-stops:list 36.0pt'>用户注册接口
            </li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                lang=EN-US>URL</span>：</span></strong></p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l41 level1 lfo2;tab-stops:list 36.0pt'><code><span
                    lang=EN-US>http://xx.com/api/user/register</span></code></li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l3 level1 lfo3;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
        </ul>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
        </p>

        <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
               style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
            <thead>
            <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                    </p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
                <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal align=center style='text-align:center'><b><span
                            style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                </td>
            </tr>
            </thead>
            <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal>是</p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal><span lang=EN-US>string</span></p>
                </td>
                <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                    <p class=MsoNormal>报告类型</p>
                </td>
            </tr>
        </table>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

        <p><span lang=EN-US>{total: 22, rows: [ {report_id: &quot;xx&quot;,
report_name: &quot;xx&quot;, report_date: &quot;xx&quot;}, {report_id:
&quot;xx&quot;, report_name: &quot;xx&quot;, report_date: &quot;xx&quot;} ] }</span></p>

        <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
        </p>

        <ul type=disc>
            <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l5 level1 lfo4;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
            </li>
        </ul>

        <p><span lang=EN-US>wDoc</span>！</p>

    </div>

    <h1><span lang=EN-US>2</span>、首页</h1>

    <h1><span lang=EN-US>3</span>、出所管理</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>3.1</span>、添加出所节点记录</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l56 level1 lfo5;tab-stops:list 36.0pt'>添加出所节点记录（服务层）
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>personNumber</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>name</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员名称</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>items</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>节点事项</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.2</span>、出所单文件上传</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l20 level1 lfo6;tab-stops:list 36.0pt'>出所单文件上传
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l29 level1 lfo7;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/upload/outList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l27 level1 lfo8;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>包含<span lang=EN-US>form</span>表单文件请求</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.3</span>、同步近一周出所戒毒人员数据</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l7 level1 lfo9;tab-stops:list 36.0pt'>同步人员数据到本地库
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l24 level1 lfo10;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/synchroPersonData</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l1 level1 lfo11;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endData</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>出所日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>days</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>近多少天（例如近一周）</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong></p>

        </div>

        <h2><span lang=EN-US>3.4</span>、同步人员照片</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l0 level1 lfo12;tab-stops:list 36.0pt'>同步人员照片（服务层）
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功；<span lang=EN-US>false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l45 level1 lfo13;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.5</span>、正常出所人员分页</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l49 level1 lfo14;tab-stops:list 36.0pt'>正常出所人员分页
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l55 level1 lfo15;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/normalPage</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l43 level1 lfo16;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'> </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l25 level1 lfo17;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.6</span>、临时出所出所人员分页</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l46 level1 lfo18;tab-stops:list 36.0pt'>临时出所出所人员分页
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l16 level1 lfo19;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/temporaryPage</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l4 level1 lfo20;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'> </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>3.7</span>、查询出所人员详情信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l47 level1 lfo21;tab-stops:list 36.0pt'>查询出所人员详情信息
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l36 level1 lfo22;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxxx/release/outPersonDetails</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l31 level1 lfo23;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;id&quot;: xxxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;name&quot;:xxxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>......<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>  </span>}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>Map</span></p>
                        <String
                                , Object>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员详情信息</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l48 level1 lfo24;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

        <h2><span lang=EN-US>3.8</span>、出所头像核对</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l19 level1 lfo25;tab-stops:list 36.0pt'>出所头像核对
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l38 level1 lfo26;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/release/headPhotoCheck</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l42 level1 lfo27;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>boolean</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>true:</span>成功<span lang=EN-US>;false:</span>失败</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

    </div>

    <h1><span lang=EN-US>4</span>、存证管理</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>4.1</span>、出所单文件下载</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l15 level1 lfo28;tab-stops:list 36.0pt'>出所单文件下载
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l50 level1 lfo29;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/download/outList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l53 level1 lfo30;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>request</span>请求</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>response</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletResponse</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>response</span>响应</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>id</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>HttpServletRequest</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>附件<span lang=EN-US>id</span></p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>void</span></p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.2</span>、查询出所节点所记录信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l39 level1 lfo31;tab-stops:list 36.0pt'>查询出所节点所记录信息<span
                        lang=EN-US>(</span>服务层<span lang=EN-US>)</span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>name</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员名称</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>[{CREATE_TIME: &quot;</span>创建时间<span
                            lang=EN-US>1&quot;, UPDATE_TIME: &quot;</span>更新时间<span
                            lang=EN-US>1&quot;, ITEM: &quot;</span>事项<span
                            lang=EN-US>1&quot;}, {CREATE_TIME: &quot;</span>创建时间<span lang=EN-US>2&quot;, UPDATE_TIME: &quot;</span>更新时间<span
                            lang=EN-US>2&quot;, ITEM: &quot;</span>事项<span lang=EN-US>2&quot;},...]</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>List&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>节点记录集合</p>
                    </td>
                    <td style='padding:.75pt .75pt .75pt .75pt'></td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.3</span>、查询存证人员详情信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l28 level1 lfo32;tab-stops:list 36.0pt'>查询存证人员详情信息
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l9 level1 lfo33;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/evidencePersonDetails</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l6 level1 lfo34;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>prisonId</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>监所编号</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>number</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员编号</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;id&quot;: xxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>&quot;name&quot;: xxxx,<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>.....<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>  </span>}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>Map</span></p>
                        <String
                                , Object>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>人员详情信息</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.4</span>、存证管理分页查询</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l8 level1 lfo35;tab-stops:list 36.0pt'>存证管理分页查询
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l32 level1 lfo36;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xxxx/evidence/evidencePageList</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l57 level1 lfo37;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>pageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageRequest</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页条件对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><span style='mso-spacerun:yes'>  </span>{total: 22, rows: [{ID: &quot;33&quot;, NAME: &quot;xixi&quot;, ROWNUM_: 21}, {ID: &quot;22&quot;, NAME: &quot;wowo&quot;, ROWNUM_: 22}]}</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'></td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>PageResponse&lt;Map<String, Object>&gt;</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>分页结果集对象</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

        </div>

        <h2><span lang=EN-US>4.5</span>、出所单文件上传</h2>

        <div style='margin-left:15.0pt'>

            <p>说明：此接口与出所管理同一接口</p>

        </div>

    </div>

    <h1><span lang=EN-US>5</span>、统计报告</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>5.1</span>、统计报告分页</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l18 level1 lfo38;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l13 level1 lfo39;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xx.com/api/user/register</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l12 level1 lfo40;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>报告类型</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><span lang=EN-US>{total: 22, rows: [{ID: “33”, createtime: “ss”, reportName:
“ss”}, {ID: “22”, createtime: “ss”, reportName: “ss“}]}</span></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US> **</span>备注<span lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>- </span>更多返回错误代码请看首页的错误代码描述</code></pre>
                    </td>
                </tr>
            </table>

        </div>

        <h2><span lang=EN-US>5.2</span>、统计<span lang=EN-US>echarts</span>展示</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l11 level1 lfo41;tab-stops:list 36.0pt'><code><span
                        lang=EN-US>http://xx.com/api/user/register</span></code></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l40 level1 lfo42;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>report_type</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>报告类型</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><span lang=EN-US>`[&quot;1&quot;,&quot;2&quot;,&quot;3&quot;] [100,200,300] </span></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US> **</span>返回参数说明<span lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>|</span>参数名<span
                                lang=EN-US>|</span>类型<span lang=EN-US>|</span>说明<span lang=EN-US>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>|:-----<span
                                style='mso-spacerun:yes'>  </span>|:-----|-----<span style='mso-spacerun:yes'>                           </span>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>| |</span>数组<span
                                lang=EN-US><span style='mso-spacerun:yes'>   </span>|key-value<span
                                style='mso-spacerun:yes'>  </span>|<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US> **</span>备注<span
                                lang=EN-US>** <o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><o:p>&nbsp;</o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US>- </span>更多返回错误代码请看首页的错误代码描述</code></pre>
                    </td>
                </tr>
            </table>

        </div>

    </div>

    <h1><span lang=EN-US>6</span>、数据接口</h1>

    <div style='margin-left:15.0pt'>

        <h2><span lang=EN-US>6.1</span>、记录数据接口调用日志</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l22 level1 lfo43;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l14 level1 lfo44;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/logsDataInteCall</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l34 level1 lfo45;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>interfaceName</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>用户名</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>url</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>请求路径</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>callModule</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用模块</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:4;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>callTime</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用时间</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l26 level1 lfo46;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.2</span>、查询各接口调用数量占比</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l30 level1 lfo47;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l37 level1 lfo48;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getInterfaceCallRatio</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l44 level1 lfo49;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>echarts</span>返回规范</code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong><span
                    lang=EN-US> | echarts</span>返回规范</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l33 level1 lfo50;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.3</span>、查询所有数据接口的调用信息</h2>

        <div style='margin-left:15.0pt'>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l21 level1 lfo51;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l2 level1 lfo52;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getDataInteCallInfo</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l51 level1 lfo53;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>[<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>     </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'INTERFACE_NAME':'</span>查询拘留所人员信息<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'URL':'http://xxx',<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_MODULE':'</span>待出所人员管理<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_TIME':'2018-03-11 18:32:32'<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>},<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>     </span>{<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'INTERFACE_NAME':'</span>查询拘留所人员信息<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'URL':'http://xxx',<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_MODULE':'</span>待出所人员管理<span
                                lang=EN-US>',<o:p></o:p></span></code></pre>
                        <pre style='word-break:break-all'><code><span
                                lang=EN-US><span style='mso-spacerun:yes'>        </span>'CALL_TIME':'2018-03-11 18:32:32'<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US><span
                                style='mso-spacerun:yes'>    </span>},<o:p></o:p></span></code></pre>
                        <pre
                                style='word-break:break-all'><code><span lang=EN-US>]</span></code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].INTERFACE_NAME</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>接口名称</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].URL</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>请求路径</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:3'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].CALL_MODULE</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用模块</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:4;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>list[].CALL_TIME</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>String</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>调用时间</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l23 level1 lfo54;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

        </div>

        <h2><span lang=EN-US>6.4</span>、查询每日接口调用频率</h2>

        <div style='margin-left:15.0pt'>

            <p>欢迎使用<span lang=EN-US>ShowDoc</span>！</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>简要描述：</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l10 level1 lfo55;tab-stops:list 36.0pt'>用户注册接口
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求<span
                    lang=EN-US>URL</span>：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l54 level1 lfo56;tab-stops:list 36.0pt'><code><span lang=EN-US>http://xxx/releaseRecord/dataInteManage/inteCallStaat/getDailyInteCallFreq</span></code>
                </li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>请求方式：</span></strong></p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l52 level1 lfo57;tab-stops:list 36.0pt'><span lang=EN-US>POST </span></li>
            </ul>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>参数：</span></strong>
            </p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;border-collapse:collapse;mso-yfti-tbllook:1184'>
                <thead>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>参数名<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>必选<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><b><span style='color:white'>类型<span lang=EN-US><o:p></o:p></span></span></b>
                        </p>
                    </td>
                    <td style='background:#0088CC;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal align=center style='text-align:center'><b><span
                                style='color:white'>说明<span lang=EN-US><o:p></o:p></span></span></b></p>
                    </td>
                </tr>
                </thead>
                <tr style='mso-yfti-irow:1'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>startDate</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>否</p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border:solid #CCCCCC 1.0pt;border-left:none;mso-border-left-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>起始调用日期</p>
                    </td>
                </tr>
                <tr style='mso-yfti-irow:2;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;border-top:none;mso-border-top-alt:
  solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>endDate</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>是</p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal><span lang=EN-US>string</span></p>
                    </td>
                    <td style='border-top:none;border-left:none;border-bottom:solid #CCCCCC 1.0pt;
  border-right:solid #CCCCCC 1.0pt;mso-border-top-alt:solid #CCCCCC .75pt;
  mso-border-left-alt:solid #CCCCCC .75pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'>
                        <p class=MsoNormal>截至调用日期</p>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回示例</span></strong></p>

            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
                   style='width:100.0%;background:silver;border-collapse:collapse;mso-yfti-tbllook:
 1184'>
                <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
                    <td style='border:solid #CCCCCC 1.0pt;mso-border-alt:solid #CCCCCC .75pt;
  padding:.75pt .75pt .75pt .75pt'><pre style='word-break:break-all'><code><span
                            lang=EN-US>echarts</span>返回规范</code></pre>
                    </td>
                </tr>
            </table>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>返回参数说明</span></strong>
            </p>

            <p><span lang=EN-US>echarts</span>返回规范</p>

            <p><strong><span style='font-family:宋体;mso-bidi-font-family:宋体'>备注</span></strong>
            </p>

            <ul type=disc>
                <li class=MsoNormal style='mso-margin-top-alt:auto;mso-margin-bottom-alt:auto;
     mso-list:l17 level1 lfo58;tab-stops:list 36.0pt'>更多返回错误代码请看首页的错误代码描述
                </li>
            </ul>

        </div>

    </div>

    <h1><span lang=EN-US>7</span>、系统管理</h1>

</div>

</body>

</html>

