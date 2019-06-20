<template>
  <div>
    <b-modal
      ref="modal-del-property"
      hide-footer title="Eliminação do imóvel"
    >
      <div class="d-block text-center">
        <h3>Tem a certeza que pretende eliminar o imóvel?</h3>
      </div>
      <b-button class="mt-2" variant="danger" block @click="confirme(false)">Não</b-button>
      <b-button class="mt-3" variant="success" block @click="confirme(true)">Sim</b-button>
    </b-modal>

    <b-modal id="info">{{ form }}</b-modal>
    <h3 class="title">Editar Imóvel</h3>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <b-form align="left" @submit="onSubmit">
            <b-row align-h="center">
              <b-col cols="4">
                <b-button-group>
                  <b-button @click="$router.go(-1)" variant="primary">Cancelar</b-button>
                  <b-button @click="removeProperty()" variant="danger">Eliminar</b-button>
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
              <LoadImages class="load-images"
                :filesData="images"
                @updateImages="updateImages"/>
              <PropertyInfo
                :descriptionData="form.description"
                :typeData="form.type"
                :typologyData="form.typology"
                :areaData="form.area"
                :districtData="form.district"
                :cityData="form.city"
                :addressData="form.address"
                :furnishedData="form.furnished"
                :availabilityData="form.availability"
                :operationData="form.operation"
                :rentPriceData="form.rentPrice"
                :sellPriceData="form.sellPrice"
                @updateDescription="updateDescription"
                @updateType="updateType"
                @updateTypology="updateTypology"
                @updateArea="updateArea"
                @updateDistrict="updateDistrict"
                @updateCity="updateCity"
                @updateAddress="updateAddress"
                @updateFurnished="updateFurnished"
                @updateAvailability="updateAvailability"
                @updateOperation="updateOperation"
                @updateRentPrice="updateRentPrice"
                @updateSellPrice="updateSellPrice"/>
            </b-card-group>

            <Bedroom
              :type="form.type"
              :bedroomsData="form.bedrooms"
              @updateBedroomType="updateBedroomType"
              @updateBedroomArea="updateBedroomArea"
              @updateBedroomFurnished="updateBedroomFurnished"
              @updateBedroomPrivateBathroom="updateBedroomPrivateBathroom"
              @updateBedroomAvailability="updateBedroomAvailability"
              @updateBedroomRentPrice="updateBedroomRentPrice"/>

            <PresentTenants
              class="present-tenants"
              :type="form.type"
              :sharedData="form.shared"
              @updateSharedFemales="updateSharedFemales"
              @updateSharedMales="updateSharedMales"
              @updateSharedSmokers="updateSharedSmokers"
              @updateSharedPets="updateSharedPets"
              @updateSharedOcupation="updateSharedOcupation"
              @addPetType="addPetType"
              @deletePetType="deletePetType"/>

            <b-card-group deck>
              <RentInclude
                :rentIncData="form.rentInc"
                @updateRentInc="updateRentInc"/>
              <DivEquipInclude
                :divEquipIncData="form.divEquipInc"
                @updateDivEquipInc="updateDivEquipInc"/>
            </b-card-group>

            <TenantsWanted
              class="tenants-wanted"
              :rentIncData="form.rentInc"
              :genreData="form.genre"
              :allowedMinAgeData="form.allowedMinAge"
              :allowedMaxAgeData="form.allowedMaxAge"
              :ocupationData="form.ocupation"
              :allowedSmokersData="form.allowedSmokers"
              :allowedPetsData="form.allowedPets"
              @updateRentInc="updateRentInc"
              @updateGenre="updateGenre"
              @updateAllowedMinAge="updateAllowedMinAge"
              @updateAllowedMaxAge="updateAllowedMaxAge"
              @updateOcupation="updateOcupation"
              @updateAllowedSmokers="updateAllowedSmokers"
              @updateAllowedPets="updateAllowedPets"/>

            <b-row class="buttons-end" align-h="center">
              <b-col cols="4">
                <b-button-group>
                  <b-button @click="$router.go(-1)" variant="primary">Cancelar</b-button>
                  <b-button @click="removeProperty()" variant="danger">Eliminar</b-button>
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
import { mapState, mapActions } from 'vuex'
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
      furnished: false,
      availability: '',
      operation: null,
      rentPrice: 0,
      sellPrice: 0,
      rentInc: [],
      genre: 'undefined',
      allowedMinAge: null,
      allowedMaxAge: null,
      ocupation: [],
      allowedSmoker: false,
      allowedPets: false,
      divEquipInc: [],
      bedrooms: [],
      shared: {}
    },
    bedroom: {
      type: null,
      area: 0,
      furnished: false,
      privateBathroom: false,
      availability: '',
      rentPrice: 0
    },
    images: []
  }),
  created () {
    if (this.property) {
      this.form.id = this.property.id
      this.form.name = this.property.name
      this.form.description = this.property.description
      this.form.type = this.property.type
      this.form.typology = this.property.typology
      this.form.area = this.property.area
      this.form.district = this.property.district
      this.form.city = this.property.city
      this.form.address = this.property.address
      this.form.furnished = this.property.furnished
      this.form.availability = this.property.availability
      this.form.operation = this.property.operation
      this.form.rentPrice = this.property.rentPrice
      this.form.sellPrice = this.property.sellPrice
      this.form.rentInc = this.property.rentInc
      this.form.genre = this.property.genre
      this.form.allowedMinAge = this.property.allowedMinAge
      this.form.allowedMaxAge = this.property.allowedMaxAge
      this.form.ocupation = this.property.ocupation
      this.form.allowedSmoker = this.property.allowedSmoker
      this.form.allowedPets = this.property.allowedPets
      this.form.divEquipInc = this.property.divEquipInc
      this.form.bedrooms = this.property.bedrooms
      this.form.shared = this.property.shared
      this.images = this.property.images
    }
  },
  computed: {
    ...mapState({
      property: state => state.properties.property
    })
  },
  methods: {
    ...mapActions('properties', ['updateProperty', 'deleteProperty']),
    updateImages (imgs) {
      this.images = imgs
    },
    onSubmit (evt) {
      evt.preventDefault()
      // this.form.bedrooms = [this.bedroom]
      // this.$bvModal.show('info')
      var payload = this.prepareImagesPayload()
      this.updateProperty(payload)
    },
    prepareImagesPayload () {
      let formData = new FormData()
      for (var i = 0; i < this.images.length; i++) {
        let img = this.images[i]
        formData.append('image[' + i + ']', img)
      }
      formData.append('property', this.form)
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
    updateFurnished (value) {
      this.form.furnished = value
    },
    updateAvailability (value) {
      this.form.availability = value
    },
    updateOperation (checked) {
      this.form.operation = checked
    },
    updateRentPrice (value) {
      this.form.rentPrice = value
    },
    updateSellPrice (value) {
      this.form.sellPrice = value
    },

    updateRentInc (checked) {
      this.form.rentInc = checked
    },
    updateGenre (value) {
      this.form.genre = value
    },
    updateAllowedMinAge (value) {
      this.form.allowedMinAge = value
    },
    updateAllowedMaxAge (value) {
      this.form.allowedMaxAge = value
    },
    updateOcupation (checked) {
      this.form.ocupation = checked
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
    updateSharedOcupation (checked) {
      this.form.shared.ocupation = checked
    },
    updateDivEquipInc (checked) {
      this.form.divEquipInc = checked
    },
    updateBedroomType (checked) {
      this.bedroom.type = checked
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
    removeProperty () {
      this.$refs['modal-del-property'].show()
    },
    confirme (bool) {
      if (bool) {
        this.deleteProperty(this.property.id)
        // TODO: Alterar
        this.$router.push({ name: 'home' })
      }
      this.$refs['modal-del-property'].hide()
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
