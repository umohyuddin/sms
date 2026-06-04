# Frontend Implementation Guide: Enterprise RBAC

With the new normalized RBAC backend, the frontend can now use standardized permission codes to control UI visibility and interaction.

## 1. Context / State Management
Your auth state should now include a list of `permissions` (permission codes) fetched from the backend after login.

**Sample User Object:**
```json
{
  "username": "admin",
  "permissions": [
    "ACADEMICS_SUBJECT_VIEW",
    "ACADEMICS_SUBJECT_CREATE",
    "FINANCE_FEE_APPROVE",
    "HR_EMPLOYEE_EXPORT"
  ]
}
```

## 2. Helper Hook: `usePermission`
Create a hook to check for permissions throughout the app.

```typescript
export const usePermission = () => {
  const { user } = useAuth(); // Assume you have an auth context

  const hasPermission = (code: string) => {
    return user?.permissions?.includes(code) || false;
  };

  return { hasPermission };
};
```

## 3. UI Component Layer: `PermissionGuard`
Use a wrapper component to hide/show elements.

```tsx
const PermissionGuard = ({ code, children, fallback = null }) => {
  const { hasPermission } = usePermission();

  if (!hasPermission(code)) {
    return fallback;
  }

  return <>{children}</>;
};

// Usage:
<PermissionGuard code="ACADEMICS_SUBJECT_CREATE">
  <Button onClick={handleAddSubject}>Add Subject</Button>
</PermissionGuard>
```

## 4. Route Guarding
In your router configuration, protect routes using the same codes.

```tsx
{
  path: '/finance/invoices',
  element: <ProtectedPage code="FINANCE_INVOICE_VIEW" element={<InvoiceList />} />
}
```

## 5. Standardized Code Pattern
Always use the pattern: `[MODULE]_[RESOURCE]_[ACTION]`
- `STUDENT_ADMISSION_CREATE`
- `FINANCE_FEE_VIEW`
- `HR_EMPLOYEE_EXPORT`
- `ACADEMICS_SUBJECT_DELETE`

This makes your frontend and backend perfectly synchronized.
