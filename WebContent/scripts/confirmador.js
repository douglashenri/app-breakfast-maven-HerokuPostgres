/**
 * Confirmação de Exclusão de um contato
 * 
 * @author Douglas Henrique
 * @param idlist
 */

function confirmar(idlist) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		window.location.href = "delete?idlist=" + idlist
	}
}