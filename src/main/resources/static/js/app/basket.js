let TF = true;

window.onload = () => {
    document.getElementById("checkAll").checked = true;
    checkAllSet(TF)
    eachPriceSet()
}

let count_change = () => {
    eachPriceSet()
}

let checkAll = () => {
    let check = document.getElementById("checkAll").checked;
    if(check == true) {
        TF = true
        checkAllSet(TF);
    } else {
        TF = false
        checkAllSet(TF);
    }
    totalPriceSet()
    
}

let isChecked = () => {
    let che = document.getElementsByName("check");
    let ch = 0;
    for(var i = 0; i < che.length; i ++){
        if(che[i].checked == true) {
            ch++;
        }
        if(ch == che.length) {
            document.getElementById("checkAll").checked = true;
        } else {
            document.getElementById("checkAll").checked = false;
        }
    }
    totalPriceSet()
}

let checkAllSet = (TF) => {
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        item.children[0].children[0].checked = TF;
    })
}

let eachPriceSet = () => {
    let total = document.getElementsByClassName("total");
    let amount = document.getElementsByName("amount");
    let table = document.getElementById("books");
    let tbody = table.children[1];
    if(tbody.children[0].children[0].innerText == "장바구니에 담은 책이 없습니다.") {
        noBooks()
    } else {
        Array.from(tbody.children).forEach((item, index) => {
            let price = item.children[2].innerHTML*1;
            let count = amount[index].value*1;
            let sum = price*count;
            total[index].innerHTML = '<span id="sum" name="sum" value="'+sum+'">'+sum+'</span>';
        })
        totalPriceSet()
    }
}

let noBooks = () => {
    let productPri = document.getElementById("productPri");
    let deliveryPri = document.getElementById("deliveryPri");
    let totalPri = document.getElementById("totalPri");
    productPri.innerHTML = 0;
    deliveryPri.innerHTML = 0;
    totalPri.innerHTML = 0;
}

let totalPriceSet = () => {
    let productPri = document.getElementById("productPri");
    let deliveryPri = document.getElementById("deliveryPri");
    let totalPri = document.getElementById("totalPri");
    let productSum = 0;
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        if(item.children[0].children[0].checked == true) {
            let sum = item.children[4].children[0].innerHTML*1;
            productSum += sum;
        }
    })
    productPri.innerHTML = productSum;
    if(productSum == 0) {
        deliveryPri.innerHTML = 0;
        totalPri.innerHTML = productSum+0;
    } else if(productSum >= 10000) {
        deliveryPri.innerHTML = 0;
        totalPri.innerHTML = productSum+0;
    } else {
        deliveryPri.innerHTML = 2000;
        totalPri.innerHTML = productSum+2000;
    }
}

let delChecked = () => {
    let che = document.getElementsByName("check");
    let delPush = [];
    for(var i = 0; i < che.length; i++) {
        if(che[i].checked == true) {
            delPush.push(che[i].id*1);
        }
    }
    var data = {
        del: delPush
    };
    
    window.location.href = '/basket/delete?isbn='+data.del;
}

let order = () => {
    let isbn = document.getElementsByName("check");
    let oa = document.getElementsByName("amount");
    let isbnList = [];
    let oaList = [];
    for(var i = 0; i < isbn.length; i++) {
        if(isbn[i].checked == true) {
            isbnList.push(isbn[i].id*1);
            oaList.push(oa[i].value*1);
        }
    }
    var data = {
        isbnList : isbnList,
        oaList : oaList
    };
    
    window.location.href = '/orders/cart/Pay?isbn='+data.isbnList+"&oa="+data.oaList;
}