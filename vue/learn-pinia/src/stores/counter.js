import { defineStore } from 'pinia';
import useUserStore from './user';

const useCounterStore = defineStore(
    'counter',
    {
        state: () => ({
            count: 10000
        }),
        getters: {
            doubleCount(state) {
                return state.count * 2;
            },
            doubleAddOne() {
                return this.doubleCount + 1;
            },
            unionOtherStore() {
                const userStore = useUserStore();

                return `${userStore.name} ${this.count}`;
            }
        },
    }
);

export default useCounterStore;