import '../css/style.css';
import '../css/title.less';
import '../css/image.css';
import zzhn from '../img/zznh.png';
import '../font/iconfont.css';

const divEl = document.createElement('div');
divEl.className = 'title';
divEl.innerHTML = '你好啊，张颖';

const bgPic = document.createElement('div');
bgPic.className = 'image-bg';

const imgEl = document.createElement('img');
imgEl.src = zzhn;

const fontEl = document.createElement('i');
fontEl.className = 'iconfont icon-ashbin';

document.body.appendChild(divEl);
document.body.appendChild(bgPic);
document.body.appendChild(imgEl);
document.body.appendChild(fontEl);

// 故意抛一个错误
// console.log(cont.length);