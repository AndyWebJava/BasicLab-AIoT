<template>
  <div>
    <svg-icon icon-class="question" @click="goto"/>
  </div>
</template>

<script>
export default {
  name: 'IoTDoc',
  data() {
    return {
      url: 'http://doc.IoT.iot.com'
    }
  },
  methods: {
    goto() {
      window.open(this.url)
    }
  }
}
</script>
