import {customRef} from 'vue';

export default function(value, delay=200) {
    let timer = null;

    return customRef((track, trigger) => {
        return {
            get() {
                track();
                return value;
            },
            set(newValue) {
                clearTimeout(timer);
                timer = setTimeout(() => {
                    value = newValue;
                    trigger();
                }, delay);
                
            }
        }
    });
}