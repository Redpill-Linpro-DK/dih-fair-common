/*
 * Inventory Update API
 * API to update inventory quantities. This specification includes a POST interface for updating inventory items.
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package dk.rdpl.dih.domain.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dk.rdpl.dih.domain.model.Inventory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
import org.hibernate.validator.constraints.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dk.rdpl.dih.domain.JSON;

/**
 * InventoryItems
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-18T11:24:02.126852940+01:00[Europe/Copenhagen]", comments = "Generator version: 7.10.0")
public class InventoryItems {
  public static final String SERIALIZED_NAME_INVENTORY = "Inventory";
  @SerializedName(SERIALIZED_NAME_INVENTORY)
  @javax.annotation.Nullable
  private List<@Valid Inventory> inventory = new ArrayList<>();

  public InventoryItems() {
  }

  public InventoryItems inventory(@javax.annotation.Nullable List<@Valid Inventory> inventory) {
    this.inventory = inventory;
    return this;
  }

  public InventoryItems addInventoryItem(Inventory inventoryItem) {
    if (this.inventory == null) {
      this.inventory = new ArrayList<>();
    }
    this.inventory.add(inventoryItem);
    return this;
  }

  /**
   * Get inventory
   * @return inventory
   */
  @javax.annotation.Nullable
  @Valid
 @Size(min=1,max=400)
  public List<@Valid Inventory> getInventory() {
    return inventory;
  }

  public void setInventory(@javax.annotation.Nullable List<@Valid Inventory> inventory) {
    this.inventory = inventory;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InventoryItems inventoryItems = (InventoryItems) o;
    return Objects.equals(this.inventory, inventoryItems.inventory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inventory);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InventoryItems {\n");
    sb.append("    inventory: ").append(toIndentedString(inventory)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("Inventory");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

  /**
   * Validates the JSON Element and throws an exception if issues found
   *
   * @param jsonElement JSON Element
   * @throws IOException if the JSON Element is invalid with respect to InventoryItems
   */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!InventoryItems.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in InventoryItems is not found in the empty JSON string", InventoryItems.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!InventoryItems.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InventoryItems` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("Inventory") != null && !jsonObj.get("Inventory").isJsonNull()) {
        JsonArray jsonArrayinventory = jsonObj.getAsJsonArray("Inventory");
        if (jsonArrayinventory != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Inventory").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Inventory` to be an array in the JSON string but got `%s`", jsonObj.get("Inventory").toString()));
          }

          // validate the optional field `Inventory` (array)
          for (int i = 0; i < jsonArrayinventory.size(); i++) {
            Inventory.validateJsonElement(jsonArrayinventory.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!InventoryItems.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'InventoryItems' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<InventoryItems> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(InventoryItems.class));

       return (TypeAdapter<T>) new TypeAdapter<InventoryItems>() {
           @Override
           public void write(JsonWriter out, InventoryItems value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public InventoryItems read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

  /**
   * Create an instance of InventoryItems given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of InventoryItems
   * @throws IOException if the JSON string is invalid with respect to InventoryItems
   */
  public static InventoryItems fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, InventoryItems.class);
  }

  /**
   * Convert an instance of InventoryItems to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

