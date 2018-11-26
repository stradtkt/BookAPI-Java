<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.codingdojo.springmysql.utils.AttributeNames" %>
<h1>New Book</h1>
<%--@elvariable id="${AttributeNames.BOOK}" type="com.codingdojo.springmysql.utils.AttributeNames.BOOK"--%>
<form:form action="/books" method="post" modelAttribute="${AttributeNames.BOOK}">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>
        <form:input type="number" path="numberOfPages"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>