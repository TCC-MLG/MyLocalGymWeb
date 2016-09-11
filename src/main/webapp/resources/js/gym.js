function validarSenha() {
    senha1 = document.getElementById('form_dados_cadastrais:senha1');
    senha2 = document.getElementById('form_dados_cadastrais:senha2');

    if (senha1.value !== senha2.value) {

        diferente();
        return false;
    }

}