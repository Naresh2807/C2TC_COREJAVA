import React from "react";
import { Card, CardContent, Typography, Button } from "@mui/material";

export default function ProductCard({ product, onEdit, onDelete }) {
  return (
    <Card sx={{ p: 2, boxShadow: 3, borderRadius: 2 }}>
      <CardContent>
        <Typography variant="h6" fontWeight="bold">
          {product.name}
        </Typography>
        <Typography variant="body1" color="textSecondary">
          ${product.price}
        </Typography>
        <div style={{ display: "flex", gap: "10px", marginTop: "10px" }}>
          <Button 
            variant="contained" 
            color="primary" 
            onClick={() => onEdit(product)}
          >
            Edit
          </Button>
          <Button 
            variant="contained" 
            color="error" 
            onClick={() => onDelete(product.id)}
          >
            Delete
          </Button>
        </div>
      </CardContent>
    </Card>
  );
}
