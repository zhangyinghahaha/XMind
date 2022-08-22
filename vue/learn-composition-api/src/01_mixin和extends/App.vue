<template>
    <div>
        <h2>{{ title }}</h2>
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
};
</script>

<style lang="scss" scoped></style>
