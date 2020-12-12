window.onload = () => {
    let oa = document.getElementsByName("amount")
    var j = 0;
    oa.forEach((item, index) => {
        j = index*2;
        item.value = searchParam("oa")[j];
    })
    totalPriceSet()
}

let totalPriceSet = () => {
    let total = document.getElementsByClassName("total");
    let productPri = document.getElementById("productPri");
    let deliveryPri = document.getElementById("deliveryPri");
    let totalPrice = document.getElementsByName("totalPri");
    let productSum = 0;

    let amount = document.getElementsByName("amount");
    let table = document.getElementById("books");
    let tbody = table.children[1];
    Array.from(tbody.children).forEach((item, index) => {
        let price = item.children[2].innerHTML*1;
        let count = amount[index].value*1;
        let sum = price*count;
        productSum += sum;
        total[index].innerHTML = sum;
    })

    productPri.innerHTML = productSum;
    if(productSum >= 10000) {
        deliveryPri.innerHTML = 0;
    } else {
        deliveryPri.innerHTML = 2000;
        productSum += 2000;
    }
    Array.from(totalPrice).forEach((item, index) => {
        item.innerHTML = productSum;
    })
}

let count_change = () => {
    totalPriceSet()
    return false;
}


function searchParam(key) {
    return new URLSearchParams(location.search).get(key);
}