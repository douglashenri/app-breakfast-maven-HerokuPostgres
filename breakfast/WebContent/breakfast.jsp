<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings("unchecked")
	ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("coffeelist");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Lista Café da Manhã</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista Café da Manhã</h1>
	<a href="novo.html" class="Botao1">Nova Inclusão</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Contribuição</th>
				<th>Opções</th>

			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%=list.get(i).getIdlist()%></td>
				<td><%=list.get(i).getPersonsName()%></td>
				<td><%=list.get(i).getCpf()%></td>
				<td><%=list.get(i).getFood()%></td>
				<td><a href="select?idlist=<%=list.get(i).getIdlist()%>"
					class="Botao1">Editar</a> <a
					href="javascript: confirmar(<%=list.get(i).getIdlist()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>