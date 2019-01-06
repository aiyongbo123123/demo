document.write("<script src='js/pad-zeropadding-min.js'></script>");
document.write("<script src='js/aes.js'></script>");

function getAesString(data,key,iv){//加密
    var key  = CryptoJS.enc.Utf8.parse(key);
    var iv   = CryptoJS.enc.Utf8.parse(iv);
    var encrypted =CryptoJS.AES.encrypt(data,key,
        {
            iv:iv,
            mode:CryptoJS.mode.CBC,
            padding:CryptoJS.pad.ZeroPadding
        });
    console.log("加密："+encrypted);
    return encrypted.toString();    //返回的是base64格式的密文
}
function getDAesString(encrypted,key,iv){//解密
    var key  = CryptoJS.enc.Utf8.parse(key);
    var iv   = CryptoJS.enc.Utf8.parse(iv);
    var decrypted =CryptoJS.AES.decrypt(encrypted,key,
        {
            iv:iv,
            mode:CryptoJS.mode.CBC,
            padding:CryptoJS.pad.ZeroPadding
        });
    console.log("解密："+decrypted);
    return decrypted.toString(CryptoJS.enc.Utf8);
}

function getAES(data){ //加密
    var key  = 'dufy20170329java';  //密钥
    var iv   = 'dufy20170329java';
    var encrypted =getAesString(data,key,iv); //密文
    var encrypted1 =CryptoJS.enc.Utf8.parse(encrypted);
    return encrypted;
}

function getDAes(data){//解密
    var key  = 'dufy20170329java';  //密钥
    var iv   = 'dufy20170329java';
    var decryptedStr =getDAesString(data,key,iv);
    return decryptedStr;
}
function encrypt(data) {
    var key  = CryptoJS.enc.Latin1.parse('dufy20170329java');
    var iv   = CryptoJS.enc.Latin1.parse('dufy20170329java');
    return CryptoJS.AES.encrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding}).toString();
}
function decrypt(data) {
    var key  = CryptoJS.enc.Latin1.parse('dufy20170329java');
    var iv   = CryptoJS.enc.Latin1.parse('dufy20170329java');
    return CryptoJS.AES.decrypt(data, key, {iv:iv,mode:CryptoJS.mode.CBC,padding:CryptoJS.pad.ZeroPadding}).toString();
}


