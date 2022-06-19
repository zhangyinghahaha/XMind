import '../css/style.css';
import '../css/title.less';
import '../css/image.css';
import zzhn from '../img/zznh.png';

const divEl = document.createElement('div');
divEl.className = 'title';
divEl.innerHTML = '你好啊，张颖';

const bgPic = document.createElement('div');
bgPic.className = 'image-bg';

const imgEl = document.createElement('img');
imgEl.src = zzhn;

document.body.appendChild(divEl);
document.body.appendChild(bgPic);
document.body.appendChild(imgEl);