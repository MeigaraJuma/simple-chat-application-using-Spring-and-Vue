<template>
  <section class="container">
    <p class="hint">How to use : Click "connect as user-1", then open new tab with the same url, click "connect as user-2". Happy chat!</p>
    <div class="connection">

      <div class="button-connect" v-on:click="connect(1)">connect as user-1</div>

      <div class="button-connect"  v-on:click="connect(2)">connect as user-2</div>
    </div>
    <div class="chat-container">

      <div class="message-container">
        <div class="message-container-scroll">
        <transition-group name="message-animation" >
      <div v-for="message in messages" :key="message.id">

        <div class="message-item-container" v-bind:class="{'me': self===message.sender, 'you':self!==message.sender }">
          <div class="message-item">
            <p v-if="self===message.sender" class="username">you</p>
            <p v-if="self!==message.sender" class="username">anonymous</p>

            {{ message.text }}</div>
        </div>
      </div>
        </transition-group>
      </div>
      </div>
    <div class="input-container"><input placeholder="Type something..." @keyup.enter="sendMessage"></div>

    </div>



  </section>
</template>

<script src="./index.js">
</script>
<style src="./index.scss" lang="scss" scoped>
</style>
