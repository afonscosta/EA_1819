<template>
  <div>
    <b-modal id="info">{{ form }}</b-modal>
    <h3>Novo Imóvel</h3>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <b-form @submit="onSubmit" @reset="onReset">
            <b-form-group
              id="input-group-1"
              label="Nome:"
              label-for="input-1"
            >
              <b-form-input
                id="input-1"
                v-model="form.name"
                placeholder="Insera o nome do imóvel"
              ></b-form-input>
            </b-form-group>

            <PropertyInfo
              @updateDescription="updateDescription"
              @updateSelectedType="updateSelectedType"
              @updateSelectedTypology="updateSelectedTypology"
              @updateArea="updateArea"
              @updateSelectedDistrict="updateSelectedDistrict"
              @updateSelectedCity="updateSelectedCity"
              @updateStreet="updateStreet"
              @updateContact="updateContact"
              @updateFurnished="updateFurnished"
              @updateAvailability="updateAvailability"
              @updateSelectedOperation="updateSelectedOperation"
              @updateRentPrice="updateRentPrice"
              @updateSellPrice="updateSellPrice"/>

            <Bedroom
              :selectedType="form.selectedType"
              @updateBedroomSelectedType="updateBedroomSelectedType"
              @updateBedroomArea="updateBedroomArea"
              @updateBedroomFurnished="updateBedroomFurnished"
              @updateBedroomPrivateBathroom="updateBedroomPrivateBathroom"
              @updateBedroomAvailability="updateBedroomAvailability"
              @updateBedroomRentPrice="updateBedroomRentPrice"/>

            <RentInclude @updateSelectedRentInc="updateSelectedRentInc"/>

            <TenantsWanted
              @updateSelectedRentInc="updateSelectedRentInc"
              @updateSelectedGenre="updateSelectedGenre"
              @updateAllowedMinAge="updateAllowedMinAge"
              @updateAllowedMaxAge="updateAllowedMaxAge"
              @updateSelectedOcupation="updateSelectedOcupation"
              @updateAllowedSmokers="updateAllowedSmokers"
              @updateAllowedPets="updateAllowedPets"/>

            <DivEquipInclude @updateSelectedDivEquipInc="updateSelectedDivEquipInc"/>

            <PresentTenants
              :selectedType="form.selectedType"
              @updateSharedFemales="updateSharedFemales"
              @updateSharedMales="updateSharedMales"
              @updateSharedSmokers="updateSharedSmokers"
              @updateSharedPets="updateSharedPets"
              @updateSharedSelectedOcupation="updateSharedSelectedOcupation"/>

            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import RentInclude from '@/components/RentInclude'
import TenantsWanted from '@/components/TenantsWanted'
import PresentTenants from '@/components/PresentTenants'
import DivEquipInclude from '@/components/DivEquipInclude'
import Bedroom from '@/components/Bedroom'
import PropertyInfo from '@/components/PropertyInfo'
import { mapActions } from 'vuex'

export default {
  name: 'sell',
  components: {
    RentInclude,
    TenantsWanted,
    PresentTenants,
    DivEquipInclude,
    Bedroom,
    PropertyInfo
  },
  data: () => ({
    form: {
      id: null,
      name: '',
      description: '',
      selectedType: '',
      selectedTypology: null,
      area: null,
      selectedDistrict: null,
      selectedCity: null,
      street: '',
      contact: '',
      furnished: false,
      availability: '',
      selectedOperation: null,
      rentPrice: 0,
      sellPrice: 0,
      selectedRentInc: [],
      selectedGenre: 'undefined',
      allowedMinAge: null,
      allowedMaxAge: null,
      selectedOcupation: [],
      allowedSmoker: false,
      allowedPets: false,
      selectedDivEquipInc: [],
      bedrooms: [],
      shared: {}
    },
    bedroom: {
      selectedType: null,
      area: 0,
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: 0
    }
  }),
  methods: {
    ...mapActions('properties', ['addProperty']),
    onSubmit (evt) {
      evt.preventDefault()
      if (this.form.id) {
        // this.updateProperty(this.form)
      } else {
        // this.form.bedrooms = [this.bedroom]
        // this.$bvModal.show('info')
        console.log(this.form)
        this.addProperty(this.form)
      }
    },
    onReset (evt) {
      evt.preventDefault()
      // Reset our form values
      this.form = {
        id: null,
        name: '',
        description: '',
        selectedType: null,
        selectedTypology: null,
        area: null,
        selectedDistrict: null,
        selectedCity: null,
        street: '',
        contact: '',
        furnished: false,
        availability: '',
        selectedOperation: null,
        rentPrice: 0,
        sellPrice: 0,
        selectedRentInc: [],
        selectedGenre: 'undefined',
        allowedMinAge: null,
        allowedMaxAge: null,
        selectedOcupation: [],
        allowedSmoker: false,
        allowedPets: false,
        selectedDivEquipInc: []
      }
    },
    updateDescription (value) {
      this.form.description = value
    },
    updateSelectedType (checked) {
      this.form.selectedType = checked
    },
    updateSelectedTypology (checked) {
      this.form.selectedTypology = checked
    },
    updateArea (value) {
      this.form.area = value
    },
    updateSelectedDistrict (checked) {
      this.form.selectedDistrict = checked
    },
    updateSelectedCity (checked) {
      this.form.selectedCity = checked
    },
    updateStreet (value) {
      this.form.street = value
    },
    updateContact (value) {
      this.form.contact = value
    },
    updateFurnished (value) {
      this.form.furnished = value
    },
    updateAvailability (value) {
      this.form.availability = value
    },
    updateSelectedOperation (checked) {
      this.form.selectedOperation = checked
    },
    updateRentPrice (value) {
      this.form.rentPrice = value
    },
    updateSellPrice (value) {
      this.form.sellPrice = value
    },

    updateSelectedRentInc (checked) {
      this.form.selectedRentInc = checked
    },
    updateSelectedGenre (value) {
      this.form.selectedGenre = value
    },
    updateAllowedMinAge (value) {
      this.form.allowedMinAge = value
    },
    updateAllowedMaxAge (value) {
      this.form.allowedMaxAge = value
    },
    updateSelectedOcupation (checked) {
      this.form.selectedOcupation = checked
    },
    updateAllowedSmokers (checked) {
      this.form.allowedSmoker = checked
    },
    updateAllowedPets (checked) {
      this.form.allowedPets = checked
    },

    updateSharedFemales (value) {
      this.form.shared.females = value
    },
    updateSharedMales (value) {
      this.form.shared.males = value
    },
    updateSharedSmokers (value) {
      this.form.shared.smokers = value
    },
    updateSharedPets (value) {
      this.form.shared.pets = value
    },
    updateSharedSelectedOcupation (checked) {
      this.form.shared.selectedOcupation = checked
    },
    updateSelectedDivEquipInc (checked) {
      this.form.selectedDivEquipInc = checked
    },
    updateBedroomSelectedType (checked) {
      this.bedroom.selectedType = checked
    },
    updateBedroomArea (value) {
      this.bedroom.area = value
    },
    updateBedroomFurnished (value) {
      this.bedroom.furnished = value
    },
    updateBedroomPrivateBathroom (value) {
      this.bedroom.privateBathroom = value
    },
    updateBedroomAvailability (value) {
      this.bedroom.availability = value
    },
    updateBedroomRentPrice (value) {
      this.bedroom.rentPrice = value
    }
  }
}
</script>
