<template>
  <b-container>
    <b-row class="justify-content-md-center">
      <b-form inline>
        <b-form-select
          v-model="selectedDistrict"
          :options="optionsDistrict"
          class="mb-2 mr-2 ml-2"
        ></b-form-select>

        <b-form-select
          v-model="selectedCity"
          :options="optionsCity"
          class="mb-2 mr-2 ml-2"
        ></b-form-select>

        <b-input
          id="inline-form-input-street"
          v-model="street"
          class="mb-2 mr-2 ml-2"
          placeholder="Rua"
        ></b-input>

        <b-form-select
          v-model="selectedDistance"
          :options="optionsDistance"
          class="mb-2 mr-2 ml-2"
        ></b-form-select>

        <b-button class="mb-2 ml-2" variant="primary">Pesquisar</b-button>
      </b-form>
    </b-row>

    <b-row class="justify-content-md-center">
      <div class="mt-3">District selected: <strong>{{ selectedDistrict }}</strong></div>
    </b-row>
    <b-row class="justify-content-md-center">
      <div class="mt-3">City selected: <strong>{{ selectedCity }}</strong></div>
    </b-row>
    <b-row class="justify-content-md-center">
      <div class="mt-3">Rua: <strong>{{ street }}</strong></div>
    </b-row>
    <b-row class="justify-content-md-center">
      <div class="mt-3">Raio: <strong>{{ selectedDistance }}</strong></div>
    </b-row>

  </b-container>
</template>

<script>
export default {
  name: 'HomeSearch',
  data: () => ({
    street: '',
    selectedDistrict: null,
    optionsDistrict: [
      { value: null, text: 'Selecione um distrito' },
      { value: 'porto', text: 'Porto' },
      { value: 'braga', text: 'Braga' },
      { value: 'lisboa', text: 'Lisboa' },
      { value: 'algarve', text: 'Algarve' }
    ],
    selectedCity: null,
    optionsCity: [
      { value: null, text: 'Selecione uma cidade' },
      { value: 'trofa', text: 'Trofa' },
      { value: 'valongo', text: 'Valongo' },
      { value: 'matosinhos', text: 'Matosinhos' },
      { value: 'penafiel', text: 'Penafiel' }
    ],
    selectedDistance: null,
    optionsDistance: [
      { value: null, text: 'Selecione uma distância' },
      { value: '20', text: '+20 km' },
      { value: '40', text: '+40 km' },
      { value: '60', text: '+60 km' },
      { value: '80', text: '+80 km' }
    ]
  })
}
</script>
