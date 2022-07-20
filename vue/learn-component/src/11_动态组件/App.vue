<template>
    <div>
        <span v-for="tab in tabs" :key="tab.id">
            <button
                :class="{ active: tab === currentTab }"
                @click="onTabClick(tab)"
            >
                {{ tab }}
            </button>
        </span>

        <!-- v-if实现 -->
        <!-- <template v-if="currentTab === 'home'">
            <Home></Home>
        </template>
        <template v-if="currentTab === 'about'">
            <About></About>
        </template>
        <template v-if="currentTab === 'category'">
            <Category></Category>
        </template> -->

        <!-- 动态组件 -->
        <component :is="currentTab" name="zhang ying"></component>
    </div>
</template>

<script>
import Home from "./pages/Home.vue";
import About from "./pages/About.vue";
import Category from "./pages/Category.vue";
export default {
    data() {
        return {
            tabs: ["home", "about", "category"],
            currentTab: "home",
        };
    },
    methods: {
        onTabClick(tab) {
            this.currentTab = tab;
        },
    },
    components: { Home, About, Category },
};
</script>

<style scoped>
.active {
    color: red;
}
</style>
