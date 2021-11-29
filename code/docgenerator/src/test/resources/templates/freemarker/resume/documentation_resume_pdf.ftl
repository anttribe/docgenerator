<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=10;IE=9;IE=8;IE=7;IE=EDGE" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta charset="utf-8" />
    <style>
        * {
            outline: none;
        }

        body {
            margin: 0;
            padding: 0;
            font-size: 14px;
            font-family: "Hiragino Sans GB", "Microsoft Yahei", "SimSun", simhei, Arial, "Helvetica Neue", Helvetica;
            color: #333;
            word-wrap: break-word;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        article,
        aside,
        details,
        figcaption,
        figure,
        footer,
        header,
        hgroup,
        main,
        menu,
        nav,
        section,
        summary {
            display: block;
        }

        progress {
            display: inline-block;
            vertical-align: baseline;
        }

        a {
            color: #555;
            background-color: transparent;
            text-decoration: none;
        }

        a:hover {
            color: #00b38a;
        }

        h1,
        h2,
        h3,
        h4,
        h5,
        h6 {
            margin: 10px 0;
            font-weight: normal;
        }

        p {
            margin: 0;
        }

        p+p {
            margin-top: 10px;
        }

        img {
            border: 0;
            vertical-align: top;
            display: inline-block;
        }

        button,
        input,
        optgroup,
        select,
        textarea {
            margin: 0;
            padding: 0;
            border: 1px solid #ededed;
            border-radius: 0;
            font-family: "Hiragino Sans GB", "Microsoft Yahei", "SimSun", simhei, Arial, "Helvetica Neue", Helvetica;
        }

        textarea {
            overflow: auto;
        }

        label,
        select,
        button,
        input[type="button"],
        input[type="reset"],
        input[type="submit"],
        input[type="radio"],
        input[type="checkbox"],
        input[type="file"] {
            cursor: pointer;
        }

        input[type=text],
        input[type=password],
        textarea {
            font-family: "Microsoft Yahei", "SimSun", simhei, Arial, "Helvetica Neue", Helvetica;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        th,
        td {
            padding: 0;
        }

        strong {
            font-weight: normal;
        }

        em,
        i {
            font-style: normal;
        }

        dl,
        dt,
        dd {
            margin: 0;
        }

        ::selection {
            color: #fff;
            background-color: #00b38a;
        }

        ::-moz-selection {
            color: #fff;
            background-color: #00b38a;
        }

        ul,
        ol {
            margin: 0;
            padding: 0;
            list-style: none;
        }

        #container {
            margin: 50px auto 54px auto;
            border: 1px solid #e3ebe9;
            border-radius: 5px;
        }

        /***** 基本信息 ****/

        .basic {
            padding: 0 50px;
            background: #FAFAFA;
            border-radius: 5px 5px 0 0;
            display: flex;
        }

        .basic .basic-info {
            position: relative;
            width: 100%;
            flex: 1;
        }

        .basic .basic-info .basic-name-area {
            overflow: hidden;
            height: 82px;
            margin-bottom: 11px;
        }

        .basic .basic-info .basic-name {
            float: left;
            max-width: 250px;
            font-size: 48px;
            color: #333333;
            line-height: 82px;
        }

        .basic .basic-info p {
            font-size: 14px;
            color: #666666;
            line-height: 20px;
            margin-top: 12px;
        }

        .basic .basic-info i {
            display: inline-block;
            margin-right: 5px;
            vertical-align: middle;
        }

        .basic .basic-info .basic-tel {
        }

        .basic-tel span {
            vertical-align: middle;
        }

        .basic-email span {
            vertical-align: middle;
        }

        /***** 基本信息 end ****/


        /***** 公共 start ****/
        .mr-template {
            padding: 50px 50px 10px;
        }

        .mr-template .mr-template_title {
            display: flex;
            justify-content: space-between;
            margin-bottom: 30px;
        }

        .mr-template .mr-template_title span {
            font-size: 18px;
            color: #333333;
            position: relative;
        }

        /***** 公共 end ****/

        /***** 自我描述 ****/
        .per .per-self_content {
            position: relative;
        }

        .per .per-self_content .per-self_des {
            margin-top: 13px;
            font-size: 14px;
            color: #666666;
            line-height: 30px;
        }

        .per .per-self_content .per-self_des p {
            margin-top: 0;
        }
        /***** 自我描述 end ****/

        /***** 工作经历 ****/
        .work-exp .work-exp_group {
            position: relative;
        }

        .work-exp .work-exp_group .work-exp_list {
            padding: 13px 0px;
        }

        .work-exp .work-exp_group .work-exp_list p {
            margin: 0;
            padding: 0;
            line-height: 26px;
        }

        .work-exp .work-exp_group .work-exp_list .exp-list_title{
            display: block;
            font-size: 14px;
            color: #333333;
        }

        .work-exp .work-exp_group .work-exp_list .exp-list_time {
            font-size: 14px;
            color: #666666;
            position: absolute;
            right: 0;
        }

        .work-exp .work-exp_group .work-exp_list .exp-list_content {
            display: block;
            font-size: 14px;
            color: #666666;
        }

        /***** 工作经历 end ****/

        /***** 项目经历 ****/

        .pro-exp .pro-exp_list {
            position: relative;
            padding: 13px 0px;
        }

        .pro-exp .pro-exp_list .exp-list_title {
            font-size: 14px;
            color: #333333;
            cursor: default;
            display: flex;
        }

        .pro-exp .pro-exp_list .exp-list_title .exp-project_name, .pro-exp .pro-exp_list .exp-list_title .exp-project_company span {
            max-width: 222px;
            display: block;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .pro-exp .pro-exp_list .exp-list_title .exp-project_company {
            display: flex;
        }

        .pro-exp .pro-exp_list .exp-list_time {
            font-size: 14px;
            color: #666666;
            position: absolute;
            right: 0;
            top: 0;
        }

        .pro-exp .pro-exp_list .exp-list_content,
        .pro-exp .pro-exp_list .exp-project_des {
            font-size: 14px;
            color: #666666;
            line-height: 30px;
            margin-top: 10px;
        }

        .pro-exp .exp-list_title.active:hover {
            color: #00B38A;
            cursor: pointer;
        }
        .pro-exp .exp-project_url {
            font-size: 14px;
            color: #666;
            line-height: 30px;
        }
        .pro-exp .pro-exp_list .exp-list_content ul, .pro-exp .pro-exp_list .exp-project_des ul {
            list-style: disc;
            -webkit-padding-start: 20px;
        }

        .pro-exp .pro-exp_list .exp-list_content ol,.pro-exp .pro-exp_list .exp-project_des ol{
            list-style-type:decimal;-webkit-padding-start:20px
        }

        /***** 项目经历 end ****/

        /***** 教育经历 ****/

        .edu-exp .edu-exp_list {
            position: relative;
            padding: 13px 0px;
        }

        .edu-exp .edu-exp_list .exp-list_time {
            font-size: 14px;
            color: #666666;
            position: absolute;
            right: 0;
        }

        .edu-exp .edu-exp_list .exp-list_top {
            display: flex;
            align-items: center;
        }

        .edu-exp .edu-exp_list .exp-list_top img {
            width: 46px;
            height: 46px;
            margin-right: 10px;
        }

        .edu-exp .edu-exp_list .exp-list_top .exp-list_right {
            display: flex;
            flex-direction: column;
            flex: 1;
            height: 46px;
            justify-content: space-between;
        }

        .edu-exp .edu-exp_list .exp-list_top .exp-list_right p,
        .edu-exp .edu-exp_list .exp-list_top .exp-list_right strong {
            font-size: 14px;
            color: #333333;
        }

        .edu-exp .edu-exp_list .exp-list_top .exp-list_right strong {
        }


        /***** 教育经历 end ****/

        /***** 社交主页 ****/

        .social-page .social-page_list {
            margin-bottom: 30px;
            position: relative;
        }

        .social-page .social-page_list .social-page_content {
            display: flex;
        }

        .social-page .social-page_list .social-page_content img {
            width: 24px;
            height: 24px;
            margin-right: 10px;
            border-radius: 50%;
        }

        .social-page .social-page_list .social-page_content p {
            font-size: 14px;
            color: #666666;
        }


        /***** 社交主页 end ****/
        /***** 图片作品 ****/

        .portfolio-page .portfolio-list{
            margin-bottom: 30px;
            position: relative;
        }
        .portfolio-page .portfolio-list .portfolio-content{
            font-size: 14px;
            color: #666666;
        }
        /***** 图片作品 end ****/

    </style>
</head>

<body>
<div id="container">
    <#if (resume)??>
        <#if (resume.personalInfo)??>
            <!-- 基本信息 -->
            <div class="basic" id="personal-info">
                <div class="basic-info">
                    <div class="basic-name-area">
                        <p class="basic-name">${resume.personalInfo.name!''}</p>
                    </div>
                    <p>
                        <span class="basic-company">${resume.personalInfo.companyName!''}</span>
                        <span> / </span>
                        <span class="basic-job">${resume.personalInfo.jobTitle!''}</span>
                    </p>
                    <p>
                        <span class="basic-exp">${resume.personalInfo.workExperience!''}年工作经验 / </span>
                        <span class="basic-edu">${resume.personalInfo.jobStatus!''} </span>
                    </p>
                    <p>
                        <span class="basic-tel">联系电话：<span>${resume.personalInfo.telephone!''}</span></span>
                    </p>
                    <p>
                        <span class="basic-email">电子邮箱：<span>${resume.personalInfo.email!''}</span></span>
                    </p>
                </div>
            </div>
            <!-- /基本信息 -->
        </#if>

        <!-- 自我描述 -->
        <div class="mr-template per">
            <div class="mr-template_title">
                <span>个人优势</span>
            </div>
            <#if (resume.selfDescription)??>
                <div class="per-self_content">
                    <div class="per-self_des">
                        <p>${resume.selfDescription!''}</p>
                    </div>
                </div>
            </#if>
        </div>
        <!-- /自我描述 -->

        <!-- 工作经历 -->
        <div class="mr-template work-exp">
            <div class="mr-template_title">
                <span>工作经历</span>
            </div>
            <#if (resume.workExperiences)?? && (resume.workExperiences?size > 0)>
                <div class="work-exp_group">
                <#list resume.workExperiences as workExperience>
                    <div class="work-exp_list">
                        <p class="exp-list_title">
                            <span>${workExperience.companyName!''}</span>(<span>${workExperience.onJobStartDate!''} - ${workExperience.obJobEndDate!''}</span>)
                        </p>
                        <p><span>职位：</span><span>${workExperience.jobTitle!''}</span></p>
                        <p class="exp-list_content">${workExperience.workContent!''}</p>
                    </div>
                </#list>
                </div>
            </#if>
        </div>
        <!-- /工作经历 -->

        <!-- 项目经历 -->
        <div class="mr-template pro-exp" id="proExp">
            <div class="mr-template_title">
                <span>项目经历</span>
            </div>
            <#if (resume.projectExperiences)?? && (resume.projectExperiences?size > 0)>
            <div class="pro-exp_group">
                <#list resume.projectExperiences as projectExperience>
                    <div class="pro-exp_list">
                        <p class="exp-list_title">
                            <span class="exp-project_name">${projectExperience.projectName!''}</span>(<span>${projectExperience.projectStartDate!''} - ${projectExperience.projectEndDate!''}</span>)
                        </p>
                        <div class="exp-project_des"><span>项目描述：</span>${projectExperience.projectDescription!''}</div>
                        <div class="exp-list_content"><span>职责：</span>${projectExperience.duty!''}</div>
                    </div>
                </#list>
            </div>
            </#if>
        </div>
        <!-- /项目经历 -->

        <!-- 教育经历 -->
        <div class="mr-template edu-exp" id="eduExp">
            <div class="mr-template_title">
                <span>教育经历</span>
            </div>
            <#if (resume.educationExperiences)?? && (resume.educationExperiences?size > 0)>
            <div class="edu-exp_group">
                <#list resume.educationExperiences as educationExperience>
                <div class="edu-exp_list">
                    <p class="exp-list_time">${educationExperience.startDate!''}-${educationExperience.endDate!''}</p>
                    <div class="exp-list_top">
                        <div class="exp-list_right">
                            <p>${educationExperience.school!''}</p>
                            <p>${educationExperience.degree!''} / ${educationExperience.major!''}</p>
                        </div>
                    </div>
                </div>
                </#list>
            </div>
            </#if>
        </div>
        <!-- /教育经历 -->
    </#if>
</div>
</body>
</html>
