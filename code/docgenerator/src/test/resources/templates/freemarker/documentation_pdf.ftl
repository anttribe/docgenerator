<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"></meta>
    <title>文档标题</title>
    <style>
        body {
            font-family:simhei;
            text-align:center;
        }
        table
        {
            border-collapse:collapse;
            border-spacing: 0;
            width: 100%;
        }

        tr {
            height: 50px;
        }

        .content td {
            border: 1px solid black;
        }

    </style>
</head>
<body>
<h1>
    文档生成器
</h1>
<#if (version)??>
    <div class="">${version!''}</div>
</#if>
<table borde=0>
    <tr>
        <td style="width: 100px;">
            TO:财务部
        </td>
        <td style="width: 80%;">
        </td>
        <td style="width: 80px;">
            日期：
        </td>
        <td style="width: 120px;">
        </td>
    </tr>
</table>
</body>
</html>
