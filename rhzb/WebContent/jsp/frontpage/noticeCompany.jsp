<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=path%>/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>金源宝——网站公告</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="jsp/frontpage/css/common.css" rel="stylesheet" />
<link href="jsp/frontpage/css/detail.css" rel="stylesheet" type="text/css">
<link href="jsp/frontpage/css/about.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="jsp/frontpage/script/jquery.min.js"></script>
<script type="text/javascript" src="jsp/frontpage/script/common.js"></script>
</head>
<body>
	<%@ include file="/jsp/frontpage/include/head.jsp"%>
	<!--网站公告-->
	<div class="bg">
		<div class="contain" id="tabs" style="margin: 0 auto;">
			<div class="text-nav">
				<ul class="clearfix">
					<li class="selected"> <a class="text-link" href="noticeCompany/openNotice">网站公告</a> </li>
        			<li> <a class="text-link" href="newCompany/openNew">媒体报道</a> </li>
					<li> <a class="text-link" href="companyReportForm/selectCompanyReportForm">运营报告</a> </li>
					<li><a class="text-link" href="index/companyInfo">公司简介</a></li>
					<li> <a class="text-link" href="law/openlawPage?style=1">法律政策</a> </li>
			        <li> <a class="text-link" href="law/openlawPage?style=2">法律声明</a> </li>
			        <li> <a class="text-link" href="law/openlawPage?style=3">资费说明</a> </li>
			        <li> <a class="text-link" href="recruit/openrecruit">招贤纳士</a> </li>
					<li><a class="text-link" href="relationUs/openRelation">联系我们</a>
					</li>
				</ul>
			</div>
			<div class="text-box">
				<div class="text-content" id="text-content">
					<h1 class="title">网站公告</h1>
					<ul class="clearfix mt20 new-list">
						<c:forEach items="${noticeCompanyInfos.lists}" var="noticeCompanyInfos">
							<li class="clearfix list-item">
								<a href="noticeCompany/noticeById?id=${noticeCompanyInfos.nid}">${noticeCompanyInfos.newsname}</a>
								<span>${noticeCompanyInfos.createtime}</span>
							</li>
						</c:forEach>
					</ul>
					<div class="pagination clearfix mrt30"> 
				      <span class="page">
					    <c:if test="${noticeCompanyInfos.currPage>1}">
					      <a href="noticeCompany/openNotice?currPage=1">首页</a>
					    </c:if>
					    <c:if test="${noticeCompanyInfos.currPage>1}">
					      <a href="noticeCompany/openNotice?currPage=${noticeCompanyInfos.currPage-1}">上一页</a>&nbsp;
					    </c:if>
					    <c:forEach var="i" begin="1" step="1" end="${noticeCompanyInfos.totalPage}">
					      <a <c:if test="${noticeCompanyInfos.currPage==i}">class="curr"</c:if> href="noticeCompany/openNotice?currPage=${i}">${i}</a>
					    </c:forEach>  
					    <c:if test="${noticeCompanyInfos.currPage<noticeCompanyInfos.totalPage}">
					      <a href="noticeCompany/openNotice?currPage=${noticeCompanyInfos.currPage+1}">下一页</a>
					    </c:if>
					    <c:if test="${noticeCompanyInfos.currPage<noticeCompanyInfos.totalPage}">
					      <a href="noticeCompany/openNotice?currPage=${noticeCompanyInfos.totalPage}">尾页</a>&nbsp;
					    </c:if>
					    <em>共${noticeCompanyInfos.totalPage}页&nbsp;</em>
				      </span>
			      	</div>
				</div>
			</div>
		</div>
	</div>
	<!--网站底部-->
	<%@ include file="/jsp/frontpage/include/foot.jsp"%>
</body>
</html>
