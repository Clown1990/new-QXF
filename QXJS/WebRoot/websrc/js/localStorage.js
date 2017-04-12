/**
 * Created by Administrator on 2017/4/10 0010.
 */
const USER_KEY = 'user';
let  user = getStorage(USER_KEY);
user =JSON.parse(user);

function getStorage(key){
    return localStorage.getItem(key)
}

function setStorage(key,value) {
    return localStorage.setItem(key,value)
}