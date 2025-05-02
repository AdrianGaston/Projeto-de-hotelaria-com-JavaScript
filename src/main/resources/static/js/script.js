$('#frmRegistro').validate({
    
    rules: {
        checkin: {
            required: true,
            date: true
        },

        checkout: {
            required: true,
            date: true
        },

        nome: {
            required: true,
            maxlength: 60,
            minWords: 2
        },

        cpf: {
            required: true,
            maxlength: 11,
        },

        telefone: {
            required: true,
            maxlength: 20
        }
    },

    // MESSAGES
    messages: {
        checkin: {
            required: "Obrigatório informar a data de entrada para realizar a reserva.",
            date: "Informe uma data válida."
        },

        checkout: {
            required: "Obrigatório informar a data de saída para realizar a reserva.",
            date: "Informe uma data válida."
        },

        nome: {
            required: "Informe seu nome para poder realizar a reserva.",
            maxlength: "O nome não pode conter mais de 60 caracteres.",
            minWords: "É preciso informar nome e sobrenome."
        },

        cpf: {
            required: "Informe seu CPF para poder realizar a reserva.",
            maxlength: "Informe um CPF válido."
        },

        telefone: {
            required: "Informe seu telefone para poder realizar a reserva.",
            maxlength: "Informe um telefone válido."
        }
      
    }
});
