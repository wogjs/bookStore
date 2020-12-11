let orderListSet = () => {
    let table = document.getElementById("orderList");
    let tbody = table.children[1];
    let tr = tbody.children;
    for(var i=0; i < tr.length; i++) {
        if(tr[i].children[0].innerHTML == tr[i+1].children[0].innerHTML) {
            console.log('같다');
        }

        if(i+1 <= tr.length) {
            break;
        }
    }
}