<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <b-form-group id="genre-form-group" label="Género:">
          <b-form-select
            v-model="selectedGenre"
            :options="optionsGenre"
            @change="updateSelectedGenre"
          ></b-form-select>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="minAge-form-group" label="Idade mínima:">
          <b-input
            v-model="allowedMinAge"
            type="number"
            @update="updateAllowedMinAge"
          ></b-input>
        </b-form-group>
      </b-col>
      <b-col>
        <b-form-group id="maxAge-form-group" label="Idade máxima:">
          <b-input
            v-model="allowedMaxAge"
            type="number"
            @update="updateAllowedMaxAge"
          ></b-input>
        </b-form-group>
      </b-col>
    </b-row>
    <b-form-group id="tenants-wanted-ocupation-form-group" label="Ocupação:">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="selectedOcupation"
        :options="optionsOcupation"
        buttons
        button-variant="danger"
        @change="updateSelectedOcupation"
      ></b-form-checkbox-group>
    </b-form-group>
    <b-row align-h="center">
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-2"
          v-model="allowedSmoker"
          name="checkbox-2"
          @change="updateAllowedSmokers"
        >Permitir fumadores</b-form-checkbox>
      </b-col>
      <b-col cols="3">
        <b-form-checkbox
          id="checkbox-3"
          v-model="allowedPets"
          name="checkbox-3"
          @change="updateAllowedPets"
        >Permitir animais de estimação</b-form-checkbox>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  data: () => ({
    selectedGenre: 'undefined',
    allowedMinAge: null,
    allowedMaxAge: null,
    selectedOcupation: [],
    allowedSmoker: false,
    allowedPets: false,
    optionsGenre: [
      { value: 'undefined', text: 'Indiferente' },
      { value: 'female', text: 'Feminino' },
      { value: 'male', text: 'Masculino' }
    ],
    optionsOcupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  methods: {
    updateSelectedGenre (value) {
      this.$emit('updateSelectedGenre', value)
    },
    updateAllowedMinAge (value) {
      this.$emit('updateAllowedMinAge', value)
    },
    updateAllowedMaxAge (value) {
      this.$emit('updateAllowedMaxAge', value)
    },
    updateSelectedOcupation (checked) {
      this.$emit('updateSelectedOcupation', checked)
    },
    updateAllowedSmokers (checked) {
      this.$emit('updateAllowedSmokers', checked)
    },
    updateAllowedPets (checked) {
      this.$emit('updateAllowedPets', checked)
    }
  }
}
</script>

<style scope>
.btn-danger:not(:disabled):not(.disabled):active,
.btn-danger:not(:disabled):not(.disabled).active,
.show > .btn-danger.dropdown-toggle {
  background-color: green !important;
  border-color: green !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group {
  display: flex !important;
  flex-wrap: wrap;
}

.btn-group > .btn,
.btn-group > .btn-group > .btn {
  margin: 0.375rem 0.75rem;
  border-radius: 0.25rem !important;
}

#tenants-wanted-ocupation-form-group {
  margin-bottom: 1rem !important;
}
</style>
