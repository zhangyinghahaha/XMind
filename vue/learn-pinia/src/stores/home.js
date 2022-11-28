import { defineStore } from 'pinia';

const useHomeStore = defineStore('homeStore', {
    state: () => ({
        banners: [],
        recommends: []
    }),
    actions: {
        fetchData() {
            
        }
    }
});

export default useHomeStore;