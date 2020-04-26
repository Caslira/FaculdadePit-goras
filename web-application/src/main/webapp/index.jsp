<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Tela de Login</title>
</head>

<% 
	/*Uso da linguagem JAVA entre os símbolos alaranjados */
	String erro = null;
	//Checar usuário e senha
	if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit") != null){
	//Usuário que foi digitado
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
	//usuáriio = admin, senha = admin
		if("admin".equalsIgnoreCase(usuario) && "admin".equalsIgnoreCase(senha)){
			out.print("Bem-vindo, " + usuario +"!");
			return;
		}else{
			erro = "Falha na tentativa de login. Dados inválidos, tente novamente.";
		}
	}
%>

<body>
	<h2>Login</h2>
	<form method="post">
		Usuário: <input type="text" name="usuario"> <br> <br>
		Senha: <input type="password" name="senha"> <br> <br>

		<button type="submit" name="submit">Entrar</button>
		<button type="reset">Reset</button>
		<br> <br>

		<%
			if(erro != null) {
		%>
		<span style="color: red;"> <%
		out.print(erro);
		%>
		</span>
		<% 
				}
		%>

	</form>
</body>
</html>