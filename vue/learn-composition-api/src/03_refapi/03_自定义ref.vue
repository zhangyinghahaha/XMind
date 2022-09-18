<template>
    <div>
        <h2>{{message}}</h2>
        <input v-model="message" type="text" />
    </div>
</template>

<script>
    import {ref, shallowRef} from 'vue';
    import debounceRef from './hook/useDebounceRef';
    export default {
        setup() {
            const message = debounceRef('hello world');
            return {message};
        }
    }
</script>

<style lang="scss" scoped>

</style>