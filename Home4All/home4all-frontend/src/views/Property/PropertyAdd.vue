<template>
  <div>
    <b-modal id="info">{{ form }}</b-modal>
    <h3 class="title">Novo Imóvel</h3>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <b-form align="left" @submit="onSubmit">
            <b-row align-h="center">
              <b-col cols="4">
                <b-button-group>
                  <b-button @click="$router.go(-1)" variant="danger">Cancelar</b-button>
                  <b-button type="submit" variant="primary">Guardar</b-button>
                </b-button-group>
              </b-col>
            </b-row>

            <b-form-group
              id="name-form-group"
              label="Nome:"
              label-for="input-1"
            >
              <b-form-input
                id="input-1"
                v-model="form.name"
                placeholder="Insira o nome do imóvel"
              ></b-form-input>
            </b-form-group>

            <b-card-group deck class="deck-images-prop-info">
              <LoadImages class="load-images" @updateImages="updateImages"/>
              <PropertyInfo
                @updateDescription="updateDescription"
                @updateType="updateType"
                @updateTypology="updateTypology"
                @updateArea="updateArea"
                @updateDistrict="updateDistrict"
                @updateCity="updateCity"
                @updateAddress="updateAddress"
                @updateLatitude="updateLatitude"
                @updateLongitude="updateLongitude"
                @updateFurnished="updateFurnished"
                @updateTotalAccess="updateTotalAccess"
                @updateAvailability="updateAvailability"
                @updateRent="updateRent"
                @updateSell="updateSell"
                @updateRentPrice="updateExpensesIncluded"
                @updateSellPrice="updateSellPrice"/>
            </b-card-group>

            <Bedroom
              :type="form.type"
              :bedrooms="form.bedrooms"
              @addBedroom="addBedroom"
              @deleteBedroom="deleteBedroom"
              @updateBedroomType="updateBedroomType"
              @updateBedroomPeopleAmount="updateBedroomPeopleAmount"
              @updateBedroomArea="updateBedroomArea"
              @updateBedroomFurnished="updateBedroomFurnished"
              @updateBedroomPrivateBathroom="updateBedroomPrivateBathroom"
              @updateBedroomAvailability="updateBedroomAvailability"
              @updateBedroomRentPrice="updateBedroomRentPrice"
              @updateBedroomImages="updateBedroomImages"/>

            <PresentTenants
              v-if="form.operation != 'sell'"
              class="present-tenants"
              :type="form.type"
              :pets="form.pets"
              @updateSharedFemales="updateSharedFemales"
              @updateSharedMales="updateSharedMales"
              @updateSharedSmokers="updateSharedSmokers"
              @updateSharedPets="updateSharedPets"
              @updateSharedOcupation="updateSharedOccupation"
              @addPetType="addPetType"
              @deletePetType="deletePetType"/>

            <b-card-group deck>
              <RentInclude
                v-if="form.operation != 'sell'"
                @updateExpensesIncluded="updateExpensesIncluded"/>
              <DivEquipInclude @updateEquipmentIncluded="updateEquipmentIncluded"/>
            </b-card-group>

            <TenantsWanted
              v-if="form.operation != 'sell'"
              class="tenants-wanted"
              @updateAllowedGenders="updateAllowedGenders"
              @updateAllowedMinAge="updateAllowedMinAge"
              @updateAllowedMaxAge="updateAllowedMaxAge"
              @updateAllowedOccupations="updateAllowedOccupations"
              @updateAllowedSmokers="updateAllowedSmokers"
              @updateAllowedPets="updateAllowedPets"/>

            <b-row class="buttons-end" align-h="center">
              <b-col cols="4">
                <b-button-group>
                  <b-button @click="$router.go(-1)" variant="danger">Cancelar</b-button>
                  <b-button type="submit" variant="primary">Guardar</b-button>
                </b-button-group>
              </b-col>
            </b-row>
          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import RentInclude from '@/components/Property/FormView/RentInclude'
import TenantsWanted from '@/components/Property/FormView/TenantsWanted'
import PresentTenants from '@/components/Property/FormView/PresentTenants'
import DivEquipInclude from '@/components/Property/FormView/DivEquipInclude'
import Bedroom from '@/components/Property/FormView/Bedroom'
import PropertyInfo from '@/components/Property/FormView/PropertyInfo'
import LoadImages from '@/components/Property/FormView/LoadImages'

export default {
  name: 'sell',
  components: {
    RentInclude,
    TenantsWanted,
    PresentTenants,
    DivEquipInclude,
    Bedroom,
    PropertyInfo,
    LoadImages
  },
  data: () => ({
    form: {
      id: null,
      name: '',
      description: '',
      type: '',
      typology: null,
      area: null,
      district: null,
      city: null,
      address: '',
      lat: 0,
      lng: 0,
      furnished: false,
      totalAccess: false,
      availability: '',
      rent: false,
      sell: false,
      rentPrice: 0,
      sellPrice: 0,
      expensesIncluded: [],
      allowedGenders: 'undefined',
      allowedMinAge: null,
      allowedMaxAge: null,
      allowedOccupations: [
        'student',
        'studentWorker',
        'worker',
        'retired',
        'unemployed'
      ],
      allowedSmokers: true,
      allowedPets: true,
      equipmentIncluded: [],
      bedrooms: [],
      females: 0,
      males: 0,
      smokers: 0,
      petsQuantity: 0,
      occupations: [],
      pets: [],
      images: []
    },
    bedroom: {
      type: null,
      area: 0,
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: 0,
      images: [],
      peopleAmount: 0
    }
  }),
  methods: {
    ...mapActions('properties', ['addProperty']),
    updateImages (imgs) {
      this.form.images = imgs
    },
    onSubmit (evt) {
      evt.preventDefault()
      if (this.form.id) {
        // this.updateProperty(this.form)
      } else {
        // this.form.bedrooms = [this.bedroom]
        // this.$bvModal.show('info')
        console.log(this.form)
        this.form.images = this.form.images.map((i) => {
          return btoa(i)
        })
        this.form.bedrooms = this.form.bedrooms.map((b) => {
          b.images = b.images.map((i) => { return btoa(i) })
          return b
        })
        this.addProperty(this.form)
        // this.$router.push({ name: 'propertyView' })
      }
    },
    prepareImagesPayload () {
      let formData = new FormData()
      for (var i = 0; i < this.form.bedrooms.length; i++) {
        var bedroom = this.form.bedrooms[i]
        var images = bedroom.images
        for (var j = 0; j < images.length; j++) {
          formData.append('bedImage[' + i + '][' + j + ']', images[j])
        }
        // delete this.form.bedrooms[i].images
      }
      for (var w = 0; w < this.images.length; w++) {
        formData.append('image[' + w + ']', this.images[w])
      }
      formData.append('property', JSON.stringify(this.form))
      return formData
    },
    updateDescription (value) {
      this.form.description = value
    },
    updateType (checked) {
      this.form.type = checked
    },
    updateTypology (checked) {
      this.form.typology = checked
    },
    updateArea (value) {
      this.form.area = value
    },
    updateDistrict (checked) {
      this.form.district = checked
    },
    updateCity (checked) {
      this.form.city = checked
    },
    updateAddress (value) {
      this.form.address = value
    },
    updateLatitude (value) {
      this.form.lat = value
    },
    updateLongitude (value) {
      this.form.lng = value
    },
    updateFurnished (value) {
      this.form.furnished = value
    },
    updateTotalAccess (value) {
      this.form.totalAccess = value
    },
    updateAvailability (value) {
      this.form.availability = value
    },
    updateRent (checked) {
      this.form.rent = checked
    },
    updateSell (checked) {
      this.form.sell = checked
    },
    updateRentPrice (value) {
      this.form.rentPrice = value
    },
    updateSellPrice (value) {
      this.form.sellPrice = value
    },

    updateExpensesIncluded (checked) {
      this.form.expensesIncluded = checked
    },
    updateAllowedGenders (value) {
      this.form.allowedGenders = value
    },
    updateAllowedMinAge (value) {
      this.form.allowedMinAge = value
    },
    updateAllowedMaxAge (value) {
      this.form.allowedMaxAge = value
    },
    updateAllowedOccupations (checked) {
      this.form.allowedOccupations = checked
    },
    updateAllowedSmokers (checked) {
      this.form.allowedSmokers = checked
    },
    updateAllowedPets (checked) {
      this.form.allowedPets = checked
    },

    updateSharedFemales (value) {
      this.form.females = value
    },
    updateSharedMales (value) {
      this.form.males = value
    },
    updateSharedSmokers (value) {
      this.form.smokers = value
    },
    updateSharedPets (value) {
      this.form.petsQuantity = value
    },
    addPetType (pet) {
      this.form.pets.push(pet)
    },
    deletePetType (idx) {
      this.form.pets.splice(idx, 1)
    },
    updateSharedOccupation (checked) {
      this.form.occupations = checked
    },
    updateEquipmentIncluded (checked) {
      this.form.equipmentIncluded = checked
    },
    addBedroom () {
      this.form.bedrooms.push(this.bedroom)
      this.bedroom = {
        type: null,
        area: 0,
        furnished: false,
        privateBathroom: false,
        availability: '',
        rentPrice: 0,
        images: [],
        peopleAmount: 0
      }
    },
    deleteBedroom (idx) {
      this.form.bedrooms.splice(idx, 1)
    },
    updateBedroomType (checked) {
      this.bedroom.type = checked
    },
    updateBedroomPeopleAmount (checked) {
      this.bedroom.peopleAmount = checked
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
    },
    updateBedroomImages (value) {
      this.bedroom.images = value
    }
  }
}
</script>

<style scope>
.deck-images-prop-info {
  margin: 1rem;
  margin-left: 0rem;
  margin-right: 0rem;
}

.tenants-wanted {
  margin: 1rem;
  margin-left: 0rem;
  margin-right: 0rem;
}

.present-tenants {
  margin: 1rem;
  margin-left: 0rem;
  margin-right: 0rem;
}

.title {
  margin-top: 2rem;
  margin-bottom: 1rem;
}

#name-form-group {
  margin-top: 1rem;
}

.buttons-end {
  margin-bottom: 1rem;
}

.btn-secondary {
  background-color: rgba(220,53,69, 0.7) !important;
}

.btn-secondary:not(:disabled):not(.disabled):active,
.btn-secondary:not(:disabled):not(.disabled).active,
.show > .btn-secondary.dropdown-toggle {
  background-color: rgba(0,128,0,0.7) !important;
  border-color: rgba(0,128,0,0.7) !important;
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
</style>
