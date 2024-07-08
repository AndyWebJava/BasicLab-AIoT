<template>
  <div>
    <svg-icon icon-class="github" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'IoTGit',
  data() {
    return {
      url: 'https://github.com/AndyWebJava/basiclab-iot.git'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
