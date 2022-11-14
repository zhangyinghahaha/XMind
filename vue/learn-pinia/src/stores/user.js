import { defineStore } from 'pinia';

const useUserStore = defineStore('userStore', {
    state: () => ({
        name: 'zhang ying',
        age: '18'
    }),
});

export default useUserStore;