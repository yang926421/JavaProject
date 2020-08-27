function getAll(i, val) {
    $("#isAll" + i).html(val + "&nbsp;&nbsp;<label onclick='getPart(" + i + ",\"" + val + "\")' style='color:#ac812e'>-收起</label>");
}

function getPart(i, val) {
    $("#isAll" + i).html(val.substring(0, 29) + "&nbsp;&nbsp;<label onclick='getAll(" + i + ",\"" + val + "\")' style='color:#ac812e'>+展开</label>");
}