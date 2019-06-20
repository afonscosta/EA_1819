<template>
  <div id="login">
    <h1> Login </h1>

    <div class="row">
      <div class="col-md">
        <hr class="left-hr" style="width: 20%">
      </div>
      <div class="col-md-1" style="width: 20px;">
        OU
      </div>
      <div class="col-md">
        <hr class="right-hr" style="width: 20%">
      </div>
    </div>

    <div class="centered">
      <input class="email-input" type="text" name="email" v-model="input.email" placeholder="Endereço de email">
    </div>
    <div class="centered">
      <input class="password-input" type="password" name="password" v-model="input.password" placeholder="Palavra-passe">
    </div>
    <div class="centered">
      <button class="button" type="button" v-on:click="login()"> Entrar </button>

      <button class="button" type="button" v-on:click="teste()"> teste </button>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'login',
  data () {
    return {
      input: {
        email: '',
        password: ''
      }
    }
  },
  methods: {
    ...mapActions('login', ['login']),
    ...mapActions('users', ['teste']),
    login () {
      if (this.input.email !== '' && this.input.password !== '') {
        this.login({
          email: this.input.email,
          password: this.input.password
        })
      }
    },
    teste () {
      this.teste()
    }
  }
}
</script>

<style scoped>

.centered {
  text-align:center;
}

div {
  padding: 10px 5px;
}

.left-hr {
  position: absolute;
  right: 0px;
}

.right-hr {
  position: absolute;
  left: 0px;
}

.button {
  background-color: rgb(241, 146, 2);
  border: none;
  color: rgb(44, 44, 44) ;
  font-weight: bold;
  padding: 20px;
  text-align: center;
  display: inline-block;
  border-radius: 6px;
  font-size: 18px;
  margin: 4px 2px;
  opacity: 0.8;
  width: 180px;
  height: 60px;
}

input {
  border: 2px solid rgb(197, 197, 197);
  width: 400px;
  font-size: 12pt;
}

.email-input {
  background-image: url(envelope.png);
  background-repeat: no-repeat;
  background-position: right center;
  background-origin: content-box;
  background-size: 2.5rem 1.8rem;
  padding: 10px;
}

.password-input {
  background-image: url(lock.png);
  background-repeat: no-repeat;
  background-position: right center;
  background-origin: content-box;
  background-size: 3rem 1.8rem;
  padding: 10px;
}

input::placeholder {
  color: rgb(43, 43, 43);
  font-weight: bold;
}

</style>
