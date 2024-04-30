<template>
  <div class="cdc">
    <h1>层叠层</h1>
    <p>处理css代码库问题，css代码库来自不同的开发人员、插件</p>
    <p>普通样式、重要样式：普通样式中用户代理优先权最低、重要样式中用户代理优先权最高</p>
    <p>相同优先权，相同优先级，顺序才变得有效</p>
    <p>层叠层，来源 优先权 （来源：6个）每个来源可以创建不同的层</p>
    <p>先比较优先权，再比较优先级</p>
    <a href="www.baidu.com">百度</a><br/>
    <a href="www.ddkk.com">ddkk</a>

    <ul>
      <li>Item One</li>
      <li>Item Two</li>
      <li>Item Three</li>
    </ul>
  </div>
</template>

<script setup>
</script>

<style scoped>
/* this does nothing */
@layer  site,page;
@layer page {
  h1 {
    text-decoration: overline;
    color: red;
  }
}

@layer site {
  h1 {
    text-decoration: underline;
    color: green;
  }
}

a {
  solid-color: #1a1a1a;
  margin: 100px;
}

li {
  border: 2px solid blue;
  padding: .5em;
}

ul {
  display: flex;
  list-style: none;
}
</style>