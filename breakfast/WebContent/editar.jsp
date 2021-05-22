<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista Café da Manhã</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Editar Lista</h1>
	<form name="frmContato" action="update">
		<table>
			<tr>
				<td><input type="text" name="idlist" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idlist"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="personsName" class="Caixa1"
					value="<%out.print(request.getAttribute("personsName"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="cpf" class="Caixa2"
					value="<%out.print(request.getAttribute("cpf"));%>"></td>
			</tr>
			<tr>
				<td><select name="food" class="Caixa1">
						<option selected
							value="<%out.print(request.getAttribute("food"));%>">
							<%
								out.print(request.getAttribute("food"));
							%>
						</option>
						<option value="Frutas">Frutas</option>
						<option value="Bolos">Bolo</option>
						<option value="Iogurte">Iogurte</option>
						<option value="Café">Café</option>
						<option value="Manteiga">Manteiga</option>
						<option value="Queijo">Queijo</option>
						<option value="Presunto">Presunto</option>
						<option value="Mortadela">Mortadela</option>
						<option value="Salame">Salame</option>
						<option value="Geleias">Geleias</option>
						<option value="Cereais">Cereais</option>
						<option value="Salgados">Salgados</option>
						<option value="Bolacha doce">Bolacha doce</option>
						<option value="Bolacha doce">Bolacha doce</option>
						<option value="Bolacha">Bolacha</option>
						<option value="Bolacha">Bolacha</option>
						<option value="Chá">Chá</option>
						<option value="Leite">Leite</option>
						<option value="Achocolatado">Achocolatado</option>
						<option value="Chocolates">Chocolates</option>
						<option value="Torradas">Torradas</option>
						<option value="Tapioca">Tapioca</option>
						<option value="Croissant">Croissant</option>
						<option value="Crepioca">Crepioca</option>
						<option value="Panqueca">Panqueca</option>
						<option value="Biscoitos">Biscoitos</option>
						<option value="Sequilhos">Sequilhos</option>
						<option value="Barra de Cereal">Barra de Cereal</option>
						<option value=" Peito de peru">Peito de peru</option>
						<option value="Bacon">Bacon</option>
						<option value="Salsicha">Salsicha</option>
						<option value="Ovo mexido ou cuzido">Ovo mexido ou cuzido</option>
						<option value="Patês">Patês</option>
						<option value="Requeijão">Requeijão</option>
						<option value="Granola">Granola</option>
						<option value="Castanhas">Castanhas</option>
						<option value="Nozes">Nozes</option>
						<option value="Mel">Mel</option>
						<option value="Pudim">Pudim</option>
						<option value="Cappuccino">Cappuccino</option>
						<option value="Suco de fruta">Suco de fruta</option>
						<option value="Suco verde">Suco verde</option>
				</select></td>

			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">

	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>