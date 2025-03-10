import React, { useState, useEffect } from "react";
import { Button, TextField, Box } from "@mui/material";
import "../styles/styles.css";

export default function ProductForm({ onAdd, onUpdate, editingProduct, setEditingProduct }) {
  const [product, setProduct] = useState({ name: "", price: "" });

  useEffect(() => {
    if (editingProduct) {
      setProduct(editingProduct);
    } else {
      setProduct({ name: "", price: "" });
    }
  }, [editingProduct]);

  const handleChange = (e) => {
    setProduct({ ...product, [e.target.name]: e.target.value });
  };

  const handleAdd = (e) => {
    e.preventDefault();
    onAdd(product);
    setProduct({ name: "", price: "" }); // Reset form
  };

  const handleUpdate = (e) => {
    e.preventDefault();
    onUpdate(product);
    setProduct({ name: "", price: "" }); // Reset form
    setEditingProduct(null); // Exit editing mode
  };

  return (
    <Box component="form" sx={{ display: "flex", gap: 2, mb: 4 }}>
      <TextField
        label="Product Name"
        name="name"
        value={product.name}
        onChange={handleChange}
        variant="outlined"
        size="small"
      />
      <TextField
        label="Price"
        name="price"
        type="number"
        value={product.price}
        onChange={handleChange}
        variant="outlined"
        size="small"
      />
      {!editingProduct ? (
        <Button onClick={handleAdd} variant="contained" color="primary">
          Add Product
        </Button>
      ) : (
        <>
          <Button onClick={handleUpdate} variant="contained" color="secondary">
            Update Product
          </Button>
          <Button onClick={() => setEditingProduct(null)} variant="outlined" color="error">
            Cancel
          </Button>
        </>
      )}
    </Box>
  );
}
