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
    Array.from(tbody.children).forEach((item, index) => {
        let price = item.children[2].innerHTML*1;
        let count = amount[index].value*1;
        let sum = price*count;
        total[index].innerHTML = '<span id="sum" name="sum" value="'+sum+'">'+sum+'</span>';
    })
    totalPriceSet()
}

let totalPriceSet = () => {
    let totalPrice = document.getElementById("totalPri");
    let totalSum = 0;
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        if(item.children[0].children[0].checked == true) {
            let sum = item.children[4].children[0].innerHTML*1;
            totalSum += sum;
        }
    })
    totalPrice.innerHTML = totalSum;    
}

let delChecked = () => {
    let che = document.getElementsByName("check");
    let delPush = new Array(che.length);
    for(var i = 0; i < che.length; i++) {
        if(che[i].checked == true) {
            delPush[i] = che[i].id*1;
        }
    }
    var data = {
        del: delPush
    };

    window.location.href = '/basket/delete?isbn='+data.del;
}