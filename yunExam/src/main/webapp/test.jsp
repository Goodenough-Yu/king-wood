<%@ page import="com.yunexam.dao.QuesBankDao" %>
<%@ page import="com.yunexam.dao.daoimpl.QuesBankDaoImpl" %>
<%@ page import="com.yunexam.domain.QuestionBank" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.yunexam.dao.ExamInforDao" %>
<%@ page import="com.yunexam.dao.daoimpl.ExamInforDaoImpl" %>
<%@ page import="com.yunexam.domain.ExamInformation" %>
<%@ page import="com.yunexam.service.PaperInfoService" %>
<%@ page import="com.yunexam.service.serviceimpl.PaperInfoServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yunexam.dao.PaperQuesDao" %>
<%@ page import="com.yunexam.dao.daoimpl.PaperQuesDaoImpl" %>
<%@ page import="com.yunexam.domain.PaperQuestion" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/12/8
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        QuesBankDao quesBankDao = new QuesBankDaoImpl();

        QuestionBank QB = null;
        QB = new QuestionBank();
        try {
            QB = quesBankDao.FindQuesBankByqbid(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    %>
    <tr>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB.getQuestion()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB.getA()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB.getB()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB.getC()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB.getD()%></span></div></td>
    </tr>
    <%
        ExamInforDao examInforDao = new ExamInforDaoImpl();

        ExamInformation EI = null;
        EI = new ExamInformation();
        try {
            EI = examInforDao.FindExamInfoByeiid(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    %>
    <tr>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=EI.getEiname()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=EI.getFinish_time()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=EI.getStart_time()%></span></div></td>
    </tr>

    <%
        PaperInfoService paperInfoService = new PaperInfoServiceImpl();
        int piid = paperInfoService.CreatePaper(1);
        try {
            List<Integer> qbid_list = paperInfoService.InsertQuestion(piid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<QuestionBank> QB_list = null;
        try {
            QB_list = new ArrayList<QuestionBank>();
            QB_list = paperInfoService.FindQusetion(piid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QuestionBank QB_q = null;
        for(int i = 0;i<QB_list.size();i++){
            QB_q = QB_list.get(i);
    %>
    <tr>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB_q.getQuestion()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB_q.getA()%></span></div></td>
        <td height="22" bgcolor="#FFFFFF"><div align="center"><span class="STYLE3"><%=QB_q.getC()%></span></div></td>
    </tr>
        <%}%>



</body>
</html>
