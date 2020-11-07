var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-login').on('click', function() {
            _this.login();
        });

        $('#btn-cardSave').on('click', function () {
            _this.cardSave();
        });

        $('#btn-addrSave').on('click', function() {
            _this.addrSave();
        });

        $('#btn-addrUpdate').on('click', function () {
            _this.addrUpdate();
        });
    },
    save : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val(),
            name: $('#name').val(),
            sex: $('#sex').val(),
            num: $('#num').val(),
            mail: $('#mail').val(),
            nic_Name: $('#nic_Name').val()

        };

        $.ajax({
            type: 'POST',
            url: '/users/userJoin',
            dataType: 'JSON',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {

            alert('회원가입 되었습니다..');
            window.location.href = '/';
        }).fail(function () {
            if(data.id == "") {
                alert('값을 입력하세요');
            } else {
                alert('이미 사용중인 아이디입니다.');
            }
        });
    },

    login : function () {
        var data = {
            id: $('#id').val(),
            pw: $('#pw').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/login',
            dataType: 'JSON',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('로그인이 되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    },

    cardSave : function () {
        var data = {
            cardNum: $('#cardNum').val(),
            cardPeriod: $('#cardPeriod').val(),
            cardCVC: $('#cardCVC').val(),
            cardPW: $('#cardPW').val(),
            cardVal: $('#cardVal').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/card',
            dataType: 'JSON',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('추가되었습니다.');
            window.location.href = '/users/mypage';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    },

    addrSave : function() {
        var YNchecked = $("input:checkbox[name='addrYN']").is(":checked");
        var data = {
            addrNic: $('#addrNic').val(),
            addrName: $('#addrName').val(),
            addrZip: $('#addrZip').val(),
            addrBas: $('#addrBas').val(),
            addrDet: $('#addrDet').val(),
            addrNum: $('#addrNum').val(),
            addrYN: $('YNvalue').val()
        };
        if(!YNchecked) {
            data.addrYN = "N";
        } else {
            data.addrYN = "Y";
        }
        console.log(data.addrYN);
        $.ajax({
            type: 'POST',
            url: '/users/addr',
            dataType: 'JSON',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('추가되었습니다.');
            window.location.href = '/users/mypage';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    },

    addrUpdate : function () {
        var YNchecked = $("input:checkbox[name='addrYN']").is(":checked");
        var addrCode = document.getElementById("btn-addrUpdate").value;
        var data = {
            addrNic: $('#addrNic').val(),
            addrName: $('#addrName').val(),
            addrZip: $('#addrZip').val(),
            addrBas: $('#addrBas').val(),
            addrDet: $('#addrDet').val(),
            addrNum: $('#addrNum').val(),
            addrYN: $('YNvalue').val()
        };
        if(!YNchecked) {
            data.addrYN = "N";
        } else {
            data.addrYN = "Y";
        }
        console.log(data.addrYN);
        $.ajax({
            type: 'PUT',
            url: '/users/addr/update/'+addrCode,
            dataType: 'JSON',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('추가되었습니다.');
            window.location.href = '/users/mypage';
        }).fail(function (error) {
            console.log(error)
            alert(JSON.stringify(error));
        });
    }
};
main.init();