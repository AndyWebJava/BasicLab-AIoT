<template>
  <div>
    <svg-icon icon-class="github" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'basiclabiotGit',
  data() {
    return {
      url: 'https://github.com/mqttsnnet/basiclabiot.git'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
