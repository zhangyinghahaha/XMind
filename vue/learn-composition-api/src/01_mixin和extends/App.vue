<template>
    <div>
        <h2>{{ title }}</h2>
        <h2>Mixin data(): {{message}}</h2>
        <button @click="foo">Mixin测试</button>
    </div>
</template>

<script>
import { demoMixin } from "./mixin/demoMixin";
export default {
    mixins: [demoMixin],
    data() {
        return {
            title: "App",
        };
    },
    created() {
        console.log('App created()');
    },
};
</script>

<style lang="scss" scoped></style>
