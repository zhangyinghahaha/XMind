import { ref, watch } from 'vue';

export default function useTitle(title = '默认Title') {
    const titleRef = ref(title);

    watch(() => titleRef.value, (newValue, oldValue) => {
        document.title = newValue;
    }, {immediate: true});
    
    return titleRef;
};
