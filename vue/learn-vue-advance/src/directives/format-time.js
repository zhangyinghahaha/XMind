import dayjs from 'dayjs';

export default function registerFormatTime(app) {
    app.directive("format-time", {
        mounted(el) {
            const value = el.textContent;
            const timestamp = parseInt(value);

            el.textContent = dayjs(timestamp).format();
        }
    });
};
