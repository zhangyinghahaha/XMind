<template>
    <div>
        App组件
        <Home></Home>
        <suspense>
            <template #default>
                <AsyncCategory></AsyncCategory>
            </template>
            <template #fallback>
                <Loading></Loading>
            </template>
        </suspense>
    </div>
</template>

<script>
import { defineAsyncComponent } from "vue";
import Home from "./Home.vue";
import Loading from './Loading.vue';
import AsyncCategory from './AsyncCategory.vue';
// import AsyncCategory from "./AsyncCategory.vue";
// const AsyncCategory = defineAsyncComponent(() => import("./AsyncCategory.vue"));
// const AsyncCategory = defineAsyncComponent({
//     loader: () => import("./AsyncCategory.vue"),
//     loadingComponent: Loading,
//     delay: 2000,
// });
export default {
    components: { Home, AsyncCategory, Loading },
};
</script>

<style lang="scss" scoped></style>
