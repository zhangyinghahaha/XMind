import { defineStore } from 'pinia';

const useCounterStore = defineStore(
    'counter',
    {
        state: () => ({
            count: 10000
        }),
    }
);

export default useCounterStore;