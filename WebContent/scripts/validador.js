/**
 * Validação de formulário
 * 
 * @author Douglas Henrique
 */

function validar() {
	let personsName = frmContato.personsName.value
	let cpf = frmContato.cpf.value
	if (personsName === "") {
		alert('Preencha o campo nome')
		frmContato.personsName.focus()
		return false
	} else if (cpf === "") {
		alert('Preencha o campo CPF')
		frmContato.cpf.focus()
		return false
	} else {
		document.forms["frmContato"].submit()
	}
}