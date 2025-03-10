import React, { useState, useEffect } from "react";
import axios from "axios";
import ProductForm from "../components/ProductForm";

const API_BASE_URL = "http://localhost:8080/admin/products"; // Backend URL

const AdminProductManager = () => {
  const [products, setProducts] = useState([]);
  const [editingProduct, setEditingProduct] = useState(null);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get(API_BASE_URL);
      setProducts(Array.isArray(response.data) ? response.data : []);
    } catch (error) {
      console.error("Error fetching products:", error);
    }
  };

  const deleteProduct = async (productId) => {
    try {
      await axios.delete(`${API_BASE_URL}/${productId}`);
      setProducts((prevProducts) => prevProducts.filter((product) => product.id !== productId));
      alert("Product deleted successfully!");
    } catch (error) {
      console.error("Error deleting product:", error);
      alert("Failed to delete product");
    }
  };

  const addProduct = async (product) => {
    if (!product.name.trim() || !product.price) {
      alert("Please enter valid product details.");
      return;
    }

    try {
      await axios.post(API_BASE_URL, product, {
        headers: { "Content-Type": "application/json" },
      });
      alert("Product added successfully!");
      fetchProducts(); // Refresh list
    } catch (error) {
      console.error("Error adding product:", error);
    }
  };

  const updateProduct = async (product) => {
    if (!product.name.trim() || !product.price) {
      alert("Please enter valid product details.");
      return;
    }

    try {
      await axios.put(`${API_BASE_URL}/${editingProduct.id}`, product, {
        headers: { "Content-Type": "application/json" },
      });
      alert("Product updated successfully!");
      setEditingProduct(null); // Reset editing state
      fetchProducts(); // Refresh list
    } catch (error) {
      console.error("Error updating product:", error);
    }
  };

  const handleEdit = (product) => {
    setEditingProduct(product);
  };

  return (
    <div className="admin-container">
      <h2>Admin Product Manager</h2>
      <ProductForm 
        onAdd={addProduct} 
        onUpdate={updateProduct} 
        editingProduct={editingProduct} 
        setEditingProduct={setEditingProduct} 
      />
      <ul className="product-list">
        {products.map((product) => (
          <li key={product.id} className="product-item">
            <span className="product-info">
              {product.name} - ${product.price}
            </span>
            <div>
              <button className="edit-btn" onClick={() => handleEdit(product)}>Edit</button>
              <button className="delete-btn" onClick={() => deleteProduct(product.id)}>Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AdminProductManager;
