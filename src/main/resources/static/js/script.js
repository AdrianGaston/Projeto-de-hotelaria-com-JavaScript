$(document).ready(function () {

    //Validação de Check-in eCheck-out
    $.validator.addMethod("depoisDoCheckin", function (valorCheckout) {
        const valorCheckin = $('#checkin').val();

        if (!valorCheckin || !valorCheckout) return true;

        const dataCheckin = new Date(valorCheckin);
        const dataCheckout = new Date(valorCheckout);

        return dataCheckout > dataCheckin;
    }, "A data de check-out deve ser posterior à data de check-in.");

    //Validação para formulário de criação da reserva (#frmRegistro)
    if ($('#frmRegistro').length) {
        $('#frmRegistro').validate({
            rules: {
                checkin: {
                    required: true,
                    date: true
                },
                checkout: {
                    required: true,
                    date: true,
                    depoisDoCheckin: true
                },
                nome: {
                    required: true,
                    maxlength: 60,
                    minlength: 5
                },
                cpf: {
                    required: true,
                    maxlength: 11,
                    minlength: 11
                },
                telefone: {
                    required: true,
                    maxlength: 20
                }
            },
            //Mensagens de erro
            messages: {
                checkin: {
                    required: "Obrigatório informar a data de entrada para realizar a reserva.",
                    date: "Informe uma data válida."
                },
                checkout: {
                    required: "Obrigatório informar a data de saída para realizar a reserva.",
                    date: "Informe uma data válida.",
                    depoisDoCheckin: "A data de saída deve ser posterior à data de entrada."
                },
                nome: {
                    required: "Informe seu nome para poder realizar a reserva.",
                    maxlength: "O nome não pode conter mais de 60 caracteres.",
                    minlength: "É preciso informar nome e sobrenome."
                },
                cpf: {
                    required: "Informe seu CPF para poder realizar a reserva.",
                    maxlength: "Informe um CPF válido, precisa conter 11 dígitos.",
                    minlength: "Informe um CPF válido, precisa conter 11 dígitos."
                },
                telefone: {
                    required: "Informe seu telefone para poder realizar a reserva.",
                    maxlength: "Informe um telefone válido."
                }
            }
        });
    }

    //Validação para formulário de edição da reserva(#frmEdicao)
    if ($('#frmEdicao').length) {
        $('#frmEdicao').validate({
            rules: {
                checkin: {
                    required: true,
                    date: true
                },
                checkout: {
                    required: true,
                    date: true,
                    depoisDoCheckin: true
                }
            },
            //Mensagens
            messages: {
                checkin: {
                    required: "Informe a nova data de entrada.",
                    date: "Informe uma data válida."
                },
                checkout: {
                    required: "Informe a nova data de saída.",
                    date: "Informe uma data válida.",
                    depoisDoCheckin: "A data de saída deve ser posterior à de entrada."
                }
            }
        });
    }

});
