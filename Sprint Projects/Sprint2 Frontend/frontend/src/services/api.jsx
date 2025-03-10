import axios from "axios";

const API_URL = "/admin/products";

export const fetchProducts = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const addProduct = async (product) => {
  const response = await axios.post(API_URL, product);
  return response.data;
};

export const updateProduct = async (id, product) => {
  const response = await axios.put(`${API_URL}/${id}`, product);
  return response.data;
};

export const deleteProduct = async (id) => {
  await axios.delete(`${API_URL}/${id}`);
};
